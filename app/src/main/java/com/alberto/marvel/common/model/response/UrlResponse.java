
package com.alberto.marvel.common.model.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UrlResponse implements Parcelable {

    @JsonProperty("type")
    private String type;
    @JsonProperty("url")
    private String url;

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.type);
        dest.writeString(this.url);
    }

    public UrlResponse() {
    }

    protected UrlResponse(Parcel in) {
        this.type = in.readString();
        this.url = in.readString();
    }

    public static final Parcelable.Creator<UrlResponse> CREATOR = new Parcelable.Creator<UrlResponse>() {
        @Override
        public UrlResponse createFromParcel(Parcel source) {
            return new UrlResponse(source);
        }

        @Override
        public UrlResponse[] newArray(int size) {
            return new UrlResponse[size];
        }
    };
}
