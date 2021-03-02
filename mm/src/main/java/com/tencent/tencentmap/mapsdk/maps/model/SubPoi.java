package com.tencent.tencentmap.mapsdk.maps.model;

public class SubPoi extends MapPoi {
    private String id;
    private String parentId;

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getParentId() {
        return this.parentId;
    }

    public void setParentId(String str) {
        this.parentId = str;
    }
}
