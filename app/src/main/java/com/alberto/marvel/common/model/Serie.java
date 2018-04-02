
package com.alberto.marvel.common.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Serie implements Parcelable {

    @JsonProperty("resourceURI")
    private String resourceURI;
    @JsonProperty("name")
    private String name;

    @JsonProperty("resourceURI")
    public String getResourceURI() {
        return resourceURI;
    }

    @JsonProperty("resourceURI")
    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.resourceURI);
        dest.writeString(this.name);
    }

    public Serie() {
    }

    protected Serie(Parcel in) {
        this.resourceURI = in.readString();
        this.name = in.readString();
    }

    public static final Parcelable.Creator<Serie> CREATOR = new Parcelable.Creator<Serie>() {
        @Override
        public Serie createFromParcel(Parcel source) {
            return new Serie(source);
        }

        @Override
        public Serie[] newArray(int size) {
            return new Serie[size];
        }
    };
}
