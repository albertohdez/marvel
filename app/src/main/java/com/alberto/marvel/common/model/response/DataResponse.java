
package com.alberto.marvel.common.model.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataResponse implements Parcelable {

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.offset);
        dest.writeString(this.limit);
        dest.writeString(this.total);
        dest.writeString(this.count);
        dest.writeList(this.results);
    }

    public DataResponse() {
    }

    protected DataResponse(Parcel in) {
        this.offset = in.readString();
        this.limit = in.readString();
        this.total = in.readString();
        this.count = in.readString();
        this.results = new ArrayList<ResultResponse>();
        in.readList(this.results, ResultResponse.class.getClassLoader());
    }

    public static final Parcelable.Creator<DataResponse> CREATOR = new Parcelable.Creator<DataResponse>() {
        @Override
        public DataResponse createFromParcel(Parcel source) {
            return new DataResponse(source);
        }

        @Override
        public DataResponse[] newArray(int size) {
            return new DataResponse[size];
        }
    };
}
