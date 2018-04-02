
package com.alberto.marvel.common.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CharactersResponse {

    @JsonProperty("code")
    private String code;
    @JsonProperty("status")
    private String status;
    @JsonProperty("copyright")
    private String copyright;
    @JsonProperty("attributionText")
    private String attributionText;
    @JsonProperty("attributionHTML")
    private String attributionHTML;
    @JsonProperty("data")
    private DataResponse data;
    @JsonProperty("etag")
    private String etag;

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("copyright")
    public String getCopyright() {
        return copyright;
    }

    @JsonProperty("copyright")
    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    @JsonProperty("attributionText")
    public String getAttributionText() {
        return attributionText;
    }

    @JsonProperty("attributionText")
    public void setAttributionText(String attributionText) {
        this.attributionText = attributionText;
    }

    @JsonProperty("attributionHTML")
    public String getAttributionHTML() {
        return attributionHTML;
    }

    @JsonProperty("attributionHTML")
    public void setAttributionHTML(String attributionHTML) {
        this.attributionHTML = attributionHTML;
    }

    @JsonProperty("data")
    public DataResponse getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(DataResponse data) {
        this.data = data;
    }

    @JsonProperty("etag")
    public String getEtag() {
        return etag;
    }

    @JsonProperty("etag")
    public void setEtag(String etag) {
        this.etag = etag;
    }

}
