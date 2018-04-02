
package com.alberto.marvel.common.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultResponse {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("modified")
    private String modified;
    @JsonProperty("resourceURI")
    private String resourceURI;
    @JsonProperty("urls")
    private List<UrlResponse> urls = null;
    @JsonProperty("thumbnail")
    private ThumbnailResponse thumbnail;
    @JsonProperty("comics")
    private ComicsResponse comics;
    @JsonProperty("stories")
    private StoriesResponse stories;
    @JsonProperty("events")
    private EventsResponse events;
    @JsonProperty("series")
    private SeriesResponse series;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("modified")
    public String getModified() {
        return modified;
    }

    @JsonProperty("modified")
    public void setModified(String modified) {
        this.modified = modified;
    }

    @JsonProperty("resourceURI")
    public String getResourceURI() {
        return resourceURI;
    }

    @JsonProperty("resourceURI")
    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    @JsonProperty("urls")
    public List<UrlResponse> getUrls() {
        return urls;
    }

    @JsonProperty("urls")
    public void setUrls(List<UrlResponse> urls) {
        this.urls = urls;
    }

    @JsonProperty("thumbnail")
    public ThumbnailResponse getThumbnail() {
        return thumbnail;
    }

    @JsonProperty("thumbnail")
    public void setThumbnail(ThumbnailResponse thumbnail) {
        this.thumbnail = thumbnail;
    }

    @JsonProperty("comics")
    public ComicsResponse getComics() {
        return comics;
    }

    @JsonProperty("comics")
    public void setComics(ComicsResponse comics) {
        this.comics = comics;
    }

    @JsonProperty("stories")
    public StoriesResponse getStories() {
        return stories;
    }

    @JsonProperty("stories")
    public void setStories(StoriesResponse stories) {
        this.stories = stories;
    }

    @JsonProperty("events")
    public EventsResponse getEvents() {
        return events;
    }

    @JsonProperty("events")
    public void setEvents(EventsResponse events) {
        this.events = events;
    }

    @JsonProperty("series")
    public SeriesResponse getSeries() {
        return series;
    }

    @JsonProperty("series")
    public void setSeries(SeriesResponse series) {
        this.series = series;
    }

}
