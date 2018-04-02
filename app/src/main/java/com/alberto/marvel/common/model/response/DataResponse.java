
package com.alberto.marvel.common.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataResponse {

    @JsonProperty("offset")
    private String offset;
    @JsonProperty("limit")
    private String limit;
    @JsonProperty("total")
    private String total;
    @JsonProperty("count")
    private String count;
    @JsonProperty("results")
    private List<ResultResponse> results = null;

    @JsonProperty("offset")
    public String getOffset() {
        return offset;
    }

    @JsonProperty("offset")
    public void setOffset(String offset) {
        this.offset = offset;
    }

    @JsonProperty("limit")
    public String getLimit() {
        return limit;
    }

    @JsonProperty("limit")
    public void setLimit(String limit) {
        this.limit = limit;
    }

    @JsonProperty("total")
    public String getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(String total) {
        this.total = total;
    }

    @JsonProperty("count")
    public String getCount() {
        return count;
    }

    @JsonProperty("count")
    public void setCount(String count) {
        this.count = count;
    }

    @JsonProperty("results")
    public List<ResultResponse> getResults() {
        return results;
    }

    @JsonProperty("results")
    public void setResults(List<ResultResponse> results) {
        this.results = results;
    }

}
