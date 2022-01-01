package io.xpipe.beacon.exchange;

import io.xpipe.beacon.message.RequestMessage;
import io.xpipe.beacon.message.ResponseMessage;
import io.xpipe.core.source.DataSourceId;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

public class ReadTableDataExchange implements MessageExchange<ReadTableDataExchange.Request, ReadTableDataExchange.Response> {

    @Override
    public String getId() {
        return "readTableData";
    }

    @Override
    public Class<ReadTableDataExchange.Request> getRequestClass() {
        return ReadTableDataExchange.Request.class;
    }

    @Override
    public Class<ReadTableDataExchange.Response> getResponseClass() {
        return ReadTableDataExchange.Response.class;
    }

    @Jacksonized
    @Builder
    @Value
    public static class Request implements RequestMessage {
        DataSourceId sourceId;
        int maxRows;
    }

    @Jacksonized
    @Builder
    @Value
    public static class Response implements ResponseMessage {

    }
}
