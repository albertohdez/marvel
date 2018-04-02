
package com.alberto.marvel.common.model.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ThumbnailResponse implements Parcelable {

    @JsonProperty("path")
    private String path;
    @JsonProperty("extension")
    private String extension;

    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    @JsonProperty("extension")
    public String getExtension() {
        return extension;
    }

    @JsonProperty("extension")
    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String buildCompleteImagePath() {
        return path + "." + extension;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.path);
        dest.writeString(this.extension);
    }

    public ThumbnailResponse() {
    }

    protected ThumbnailResponse(Parcel in) {
        this.path = in.readString();
        this.extension = in.readString();
    }

    public static final Parcelable.Creator<ThumbnailResponse> CREATOR = new Parcelable.Creator<ThumbnailResponse>() {
        @Override
        public ThumbnailResponse createFromParcel(Parcel source) {
            return new ThumbnailResponse(source);
        }

        @Override
        public ThumbnailResponse[] newArray(int size) {
            return new ThumbnailResponse[size];
        }
    };
}
