package com.github.aerosprix.resource_booking_system.resource.dto;

import org.openapitools.jackson.nullable.JsonNullable;

public class ResourceUpdateRequest {
    private JsonNullable<String> name = JsonNullable.undefined();
    private JsonNullable<String> category = JsonNullable.undefined();
    private JsonNullable<String> description = JsonNullable.undefined();
    private JsonNullable<Boolean> active = JsonNullable.undefined();

    public JsonNullable<String> getName() {
        return name;
    }

    public void setName(JsonNullable<String> name) {
        this.name = name;
    }

    public JsonNullable<String> getCategory() {
        return category;
    }

    public void setCategory(JsonNullable<String> category) {
        this.category = category;
    }

    public JsonNullable<String> getDescription() {
        return description;
    }

    public void setDescription(JsonNullable<String> description) {
        this.description = description;
    }

    public JsonNullable<Boolean> getActive() {
        return active;
    }

    public void setActive(JsonNullable<Boolean> active) {
        this.active = active;
    }
}
