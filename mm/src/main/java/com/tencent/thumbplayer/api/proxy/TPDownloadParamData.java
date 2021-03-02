package com.tencent.thumbplayer.api.proxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TPDownloadParamData {
    public String audioTrackKeyId;
    private String[] bakUrl;
    private String base;
    private int clipCount;
    private int clipNo;
    private String currentFormat;
    private int currentFormatID;
    private List<Map<String, String>> defInfoList;
    private int dlType;
    private String downloadFileID;
    private int endTimeMS;
    private int expectDelay;
    private Map<String, String> extInfoMap;
    private boolean extraParam;
    private long fileDuration;
    private String fileMD5;
    private long fileSize;
    public String flowId;
    private Map<String, Integer> formatInfo;
    private int fp2p;
    private boolean isCharge;
    private boolean isOffline;
    private String linkVid;
    private String m3u8;
    private boolean needEncryptCache;
    private ArrayList<String> pcdnUrlList;
    private ArrayList<Integer> pcdnVtList;
    private String playDefinition;
    private long preloadDuration;
    private long preloadSize;
    private String savePath;
    private boolean selfAdaption;
    private int starTimeMS;
    private int testid;
    private long tm;
    public String url;
    private ArrayList<String> urlCdnidList;
    private ArrayList<String> urlCookieList;
    private int urlExpireTime;
    private ArrayList<String> urlHostList;
    private String vid;

    public TPDownloadParamData() {
        this.clipCount = 1;
        this.clipNo = 1;
        this.isOffline = false;
        this.selfAdaption = false;
    }

    public TPDownloadParamData(int i2) {
        this(null, i2);
    }

    public TPDownloadParamData(String str) {
        this(str, 0);
    }

    public TPDownloadParamData(String str, int i2) {
        this.clipCount = 1;
        this.clipNo = 1;
        this.isOffline = false;
        this.selfAdaption = false;
        this.downloadFileID = str;
        this.dlType = i2;
    }

    public ArrayList<Integer> getPcdnVtList() {
        return this.pcdnVtList;
    }

    public void setPcdnVtList(ArrayList<Integer> arrayList) {
        this.pcdnVtList = arrayList;
    }

    public ArrayList<String> getPcdnUrlList() {
        return this.pcdnUrlList;
    }

    public void setPcdnUrlList(ArrayList<String> arrayList) {
        this.pcdnUrlList = arrayList;
    }

    public String[] getBakUrl() {
        return this.bakUrl;
    }

    public void setBakUrl(String[] strArr) {
        this.bakUrl = strArr;
    }

    public int getDlType() {
        return this.dlType;
    }

    public void setDlType(int i2) {
        this.dlType = i2;
    }

    public String getDownloadFileID() {
        return this.downloadFileID;
    }

    public void setDownloadFileID(String str) {
        this.downloadFileID = str;
    }

    public String getVid() {
        return this.vid;
    }

    public void setVid(String str) {
        this.vid = str;
    }

    public ArrayList<String> getUrlHostList() {
        return this.urlHostList;
    }

    public void setUrlHostList(ArrayList<String> arrayList) {
        this.urlHostList = arrayList;
    }

    public ArrayList<String> getUrlCookieList() {
        return this.urlCookieList;
    }

    public void setUrlCookieList(ArrayList<String> arrayList) {
        this.urlCookieList = arrayList;
    }

    public ArrayList<String> getUrlCdnidList() {
        return this.urlCdnidList;
    }

    public void setUrlCdnidList(ArrayList<String> arrayList) {
        this.urlCdnidList = arrayList;
    }

    public int getUrlExpireTime() {
        return this.urlExpireTime;
    }

    public void setUrlExpireTime(int i2) {
        this.urlExpireTime = i2;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public void setFileSize(long j2) {
        this.fileSize = j2;
    }

    public long getFileDuration() {
        return this.fileDuration;
    }

    public void setFileDuration(long j2) {
        this.fileDuration = j2;
    }

    public boolean isExtraParam() {
        return this.extraParam;
    }

    public void setExtraParam(boolean z) {
        this.extraParam = z;
    }

    public String getPlayDefinition() {
        return this.playDefinition;
    }

    public void setPlayDefinition(String str) {
        this.playDefinition = str;
    }

    public String getCurrentFormat() {
        return this.currentFormat;
    }

    public void setCurrentFormat(String str) {
        this.currentFormat = str;
    }

    public int getCurrentFormatID() {
        return this.currentFormatID;
    }

    public void setCurrentFormatID(int i2) {
        this.currentFormatID = i2;
    }

    public Map<String, Integer> getFormatInfo() {
        return this.formatInfo;
    }

    public void setFormatInfo(Map<String, Integer> map) {
        this.formatInfo = map;
    }

    public boolean isCharge() {
        return this.isCharge;
    }

    public void setCharge(boolean z) {
        this.isCharge = z;
    }

    public boolean isNeedEncryptCache() {
        return this.needEncryptCache;
    }

    public void setNeedEncryptCache(boolean z) {
        this.needEncryptCache = z;
    }

    public int getStarTimeMS() {
        return this.starTimeMS;
    }

    public void setStarTimeMS(int i2) {
        this.starTimeMS = i2;
    }

    public int getEndTimeMS() {
        return this.endTimeMS;
    }

    public void setEndTimeMS(int i2) {
        this.endTimeMS = i2;
    }

    public int getClipCount() {
        return this.clipCount;
    }

    public void setClipCount(int i2) {
        this.clipCount = i2;
    }

    public int getClipNo() {
        return this.clipNo;
    }

    public void setClipNo(int i2) {
        this.clipNo = i2;
    }

    public String getFileMD5() {
        return this.fileMD5;
    }

    public void setFileMD5(String str) {
        this.fileMD5 = str;
    }

    public String getBase() {
        return this.base;
    }

    public void setBase(String str) {
        this.base = str;
    }

    public String getLinkVid() {
        return this.linkVid;
    }

    public void setLinkVid(String str) {
        this.linkVid = str;
    }

    public String getM3u8() {
        return this.m3u8;
    }

    public void setM3u8(String str) {
        this.m3u8 = str;
    }

    public long getTm() {
        return this.tm;
    }

    public void setTm(long j2) {
        this.tm = j2;
    }

    public int getFp2p() {
        return this.fp2p;
    }

    public void setFp2p(int i2) {
        this.fp2p = i2;
    }

    public int getTestid() {
        return this.testid;
    }

    public void setTestid(int i2) {
        this.testid = i2;
    }

    public long getPreloadSize() {
        return this.preloadSize;
    }

    public void setPreloadSize(long j2) {
        this.preloadSize = j2;
    }

    public long getPreloadDuration() {
        return this.preloadDuration;
    }

    public void setPreloadDuration(long j2) {
        this.preloadDuration = j2;
    }

    public String getSavePath() {
        return this.savePath;
    }

    public void setSavePath(String str) {
        this.savePath = str;
    }

    public Map<String, String> getExtInfoMap() {
        return this.extInfoMap;
    }

    public void setExtInfoMap(Map<String, String> map) {
        this.extInfoMap = map;
    }

    public List<Map<String, String>> getDefInfoList() {
        return this.defInfoList;
    }

    public void setDefInfoList(List<Map<String, String>> list) {
        this.defInfoList = list;
    }

    public String getUrl() {
        return this.url;
    }

    public void setAudioTrackKeyId(String str) {
        this.audioTrackKeyId = str;
    }

    public String getAudioTrackKeyId() {
        return this.audioTrackKeyId;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public boolean isOffline() {
        return this.isOffline;
    }

    public void setOffline(boolean z) {
        this.isOffline = z;
    }

    public boolean getSelfAdaption() {
        return this.selfAdaption;
    }

    public void setSelfAdaption(boolean z) {
        this.selfAdaption = z;
    }

    public String getFlowId() {
        return this.flowId;
    }

    public void setFlowId(String str) {
        this.flowId = str;
    }

    public int getExceptDelay() {
        return this.expectDelay;
    }

    public void setExpectDelay(int i2) {
        this.expectDelay = i2;
    }
}
