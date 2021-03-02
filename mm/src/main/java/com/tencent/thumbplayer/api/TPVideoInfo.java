package com.tencent.thumbplayer.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.utils.b;
import java.util.ArrayList;

public class TPVideoInfo {
    private Builder builder;
    private String definition;
    private ArrayList<TPDownloadParamData> downloadParamList;
    private String fileID;
    private long height;
    private int videoCodecId;
    private long width;

    private TPVideoInfo(Builder builder2) {
        AppMethodBeat.i(189061);
        this.width = builder2.width;
        this.height = builder2.height;
        this.videoCodecId = builder2.videoCodecId;
        this.fileID = builder2.fileID;
        this.definition = builder2.definition;
        this.downloadParamList = builder2.downloadParamList;
        this.builder = builder2;
        AppMethodBeat.o(189061);
    }

    public Builder getBuilder() {
        return this.builder;
    }

    public long getWidth() {
        return this.width;
    }

    public long getHeight() {
        return this.height;
    }

    public String getDefinition() {
        return this.definition;
    }

    public int getVideoCodecId() {
        return this.videoCodecId;
    }

    public String getProxyFileID() {
        return this.fileID;
    }

    public ArrayList<TPDownloadParamData> getDownloadPraramList() {
        return this.downloadParamList;
    }

    public static class Builder {
        private String definition;
        private ArrayList<TPDownloadParamData> downloadParamList;
        private String fileID;
        private long height;
        private int videoCodecId;
        private long width;

        public Builder size(long j2, long j3) {
            this.width = j2;
            this.height = j3;
            return this;
        }

        public Builder definition(String str) {
            this.definition = str;
            return this;
        }

        public Builder videoCodecId(int i2) {
            this.videoCodecId = i2;
            return this;
        }

        public Builder fileId(String str) {
            this.fileID = str;
            return this;
        }

        public Builder downloadParam(TPDownloadParamData tPDownloadParamData) {
            AppMethodBeat.i(189059);
            if (b.isEmpty(this.downloadParamList)) {
                this.downloadParamList = new ArrayList<>();
            } else {
                this.downloadParamList.clear();
            }
            this.downloadParamList.add(tPDownloadParamData);
            AppMethodBeat.o(189059);
            return this;
        }

        public Builder downloadParamList(ArrayList<TPDownloadParamData> arrayList) {
            this.downloadParamList = arrayList;
            return this;
        }

        public TPVideoInfo build() {
            AppMethodBeat.i(189060);
            TPVideoInfo tPVideoInfo = new TPVideoInfo(this);
            AppMethodBeat.o(189060);
            return tPVideoInfo;
        }
    }
}
