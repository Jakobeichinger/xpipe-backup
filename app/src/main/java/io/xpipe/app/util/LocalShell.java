package io.xpipe.app.util;

import io.xpipe.core.process.ProcessControlProvider;
import io.xpipe.core.process.ShellControl;
import io.xpipe.core.process.ShellDialects;

import lombok.Getter;

public class LocalShell {

    @Getter
    private static ShellControlCache localCache;

    private static ShellControl local;
    private static ShellControl localPowershell;

    public static void init() throws Exception {
        local = ProcessControlProvider.get().createLocalProcessControl(false).start();
        localCache = new ShellControlCache(local);
    }

    public static void reset() {
        if (local != null) {
            local.kill();
            local = null;
        }
        localCache = null;
        if (localPowershell != null) {
            localPowershell.kill();
            localPowershell = null;
        }
    }

    public static ShellControl getLocalPowershell() throws Exception {
        var s = getShell();
        if (ShellDialects.isPowershell(s)) {
            return s;
        }

        if (localPowershell == null) {
            localPowershell = ProcessControlProvider.get()
                    .createLocalProcessControl(false)
                    .subShell(ShellDialects.POWERSHELL)
                    .withoutLicenseCheck()
                    .start();
        }
        return localPowershell.start();
    }

    public static boolean isLocalShellInitialized() {
        return local != null;
    }

    public static ShellControl getShell() throws Exception {
        if (local == null) {
            throw new IllegalStateException("Local shell not initialized yet");
        }

        return local.start();
    }
}
