# XPipe Vault (Keep this repository private!)

This repository contains all connection information that is designated to be shared.

You can sync with this repository in all XPipe application instances the same way, every change you make in one instance will be reflected in the repository. 

## Category list

- **Connections**
  - [**Eichingernetz**](categories/e6b382aa-db91-494c-a2fc-78c5492a7320)
    - [**Unifi Devices**](categories/25b7b2e9-a86d-48f5-8b4b-013660a14bfe)
  - [**Default**](categories/97458c07-75c0-4f9d-a06e-92d8cdf67c40)
- **Scripts**
  - [**Custom**](categories/d3496db5-b709-41f9-abc0-ee0a660fbab9)
- **Identities**
  - [**Tacacs**](categories/19a227e6-0ad4-4bb5-9398-41bbb7ff3a85)
  - [**Synced**](categories/69aa5040-28dc-451e-b4ff-1192ce5e1e3c)
  - [**Radius Accounting UDM-Pro**](categories/442b5a90-2fe8-4a36-b2b7-dbcb9e3d529f)
  - [**Local**](categories/e784de4e-abea-4cb8-a839-fc557cd23097)
  - [**LDAP**](categories/440a487a-b950-4bc8-ac79-d2473af92f1d)

## Connection list

**All connections / Eichingernetz**

empty

**All connections / Eichingernetz / Unifi Devices**

- [**UDM-Pro Gateway ssh**](stores/7c2b6e53-cccf-4b63-a7d3-5e007d4bd853)

**All connections / Default**

- [**Windowsserver-HP**](stores/eb186e06-f3db-495d-97ee-ccfd327a148f)

**All scripts / Custom**

- [**My scripts**](stores/a9945ad2-db61-4304-97d7-5dc4330691a7)

**All identities / Tacacs**

empty

**All identities / Synced**

empty

**All identities / Radius Accounting UDM-Pro**

empty

**All identities / Local**

- [**AD-Domainadmin**](stores/5b498cc6-9442-4365-bc89-649cd7c4354c)
- [**UDM-Pro Root User**](stores/b0e30d74-e66b-4644-b19e-6f444877388a)
- [**Unifi Devices SSH Agent Testing Stage**](stores/ce25bc0e-1b7e-4a01-9bec-c2a902e9c9f4)

**All identities / LDAP**

empty


## Secret encryption

You have the option to fetch any sensitive information like passwords from outside sources like password managers or enter them at connection time through a prompt window. In that case, XPipe doesn't have to store any secrets itself.

In case you choose to store passwords and other secrets within XPipe, all sensitive information is encrypted when it is saved using AES with either:

- A dynamically generated key file `vaultkey` (The data can then only be decrypted with that file present)
- A custom passphrase that can be set for your user in the settings menu, combined with the vaultkey file (This option can only as secure as the password you choose)

By default, general connection data is not encrypted, only secrets are.
So things like hostnames and usernames are stored without encryption, which is in line with many other tools.
There is an available vault setting in the settings menu to encrypt all connection data if you want to do that.

## Cloning the repository on other systems

Nowadays, most providers require a personal access token (PAT) to authenticate from the command-line instead of traditional passwords.
You can find common (PAT) pages here:
- **GitHub**: [Personal access tokens (classic)](https://github.com/settings/tokens)
- **GitLab**: [Personal access token](https://docs.gitlab.com/ee/user/profile/personal_access_tokens.html)
- **BitBucket**: [Personal access token](https://support.atlassian.com/bitbucket-cloud/docs/access-tokens/)
- **Gitea**: `Settings -> Applications -> Manage Access Tokens section`
Set the token permission for repository to Read and Write. The rest of the token permissions can be set as Read.

Even if your git client prompts you for a password, you should enter your token unless your provider still uses passwords.

If you don't want to enter your credentials every time, you can use any git credentials manager for that.
For more information, see for example:
- https://git-scm.com/doc/credential-helpers
- https://docs.github.com/en/get-started/getting-started-with-git/caching-your-github-credentials-in-git

Some modern git clients also take care of storing credentials automatically.

## Troubleshooting

### Adding connections to the repository

By default, no categories are set to shared so that you have explicit control on what connections to commit.

To have your connections of a category put inside your git repository,
you either need to right-click the category or click on the `⚙️` icon when hovering over the category
in your `Connections` tab under the category overview on the left side.
Then click on `Add to git repository` to sync the category and connections to your git repository.
This will add all shareable connections in that category to the git repository.

### Local connections are not synced

Any connection located under the local machine can not be shared as it refers to connections and data that are only available on the local system.
