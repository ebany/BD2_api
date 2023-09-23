package org.usac.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ebany
 */
public class JuegoDto {

    private Long id;
    private List<Long> genres;
    private String name;
    private String summary;
    private String storyline;
    private String first_release_date;
    private Double rating;
    private Long rating_count;
    private Double aggregated_rating;
    private Long aggregated_rating_count;
    private List<Long> platforms;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getGenres() {
        if (genres == null) {
            return new ArrayList();
        }
        return genres;
    }

    public void setGenres(List<Long> genres) {
        this.genres = genres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        if (summary == null) {
            return "";
        }
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getStoryline() {
        if (storyline == null) {
            return "";
        }
        return storyline;
    }

    public void setStoryline(String storyline) {
        this.storyline = storyline;
    }

    public String getFirst_release_date() {
        if (first_release_date == null) {
            return "";
        }
        return first_release_date;
    }

    public void setFirst_release_date(String first_release_date) {
        this.first_release_date = first_release_date;
    }

    public Double getRating() {
        if (rating == null) {
            return 0.0;
        }
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Long getRating_count() {
        if (rating_count == null) {
            return 0L;
        }
        return rating_count;
    }

    public void setRating_count(Long rating_count) {
        this.rating_count = rating_count;
    }

    public Double getAggregated_rating() {
        if (aggregated_rating == null) {
            return 0.0;
        }
        return aggregated_rating;
    }

    public void setAggregated_rating(Double aggregated_rating) {
        this.aggregated_rating = aggregated_rating;
    }

    public Long getAggregated_rating_count() {
        if (aggregated_rating_count == null) {
            return 0L;
        }
        return aggregated_rating_count;
    }

    public void setAggregated_rating_count(Long aggregated_rating_count) {
        this.aggregated_rating_count = aggregated_rating_count;
    }

    public List<Long> getPlatforms() {
        if(platforms == null) {
            return new ArrayList();
        }
        return platforms;
    }

    public void setPlatforms(List<Long> platforms) {
        this.platforms = platforms;
    }

    @Override
    public String toString() {
        return "JuegoDto{" + "id=" + id + ", genres=" + genres + ", name=" + name + ", summary=" + summary + ", storyline=" + storyline + ", first_release_date=" + first_release_date + ", rating=" + rating + ", rating_count=" + rating_count + ", aggregated_rating=" + aggregated_rating + ", aggregated_rating_count=" + aggregated_rating_count + ", platforms=" + platforms + '}';
    }

}
