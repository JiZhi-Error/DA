package com.tencent.thumbplayer.core.downloadproxy.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class TPDownloadParam {
    private static final String FILE_NAME = "TPDownloadParam";
    private int dlType;
    private Map<String, Object> extInfoMap;
    private ArrayList<String> urlList;

    public TPDownloadParam(ArrayList<String> arrayList, int i2, Map<String, Object> map) {
        this.urlList = arrayList;
        this.dlType = i2;
        this.extInfoMap = map;
    }

    public ArrayList<String> getUrlList() {
        return this.urlList;
    }

    public void setUrlList(ArrayList<String> arrayList) {
        this.urlList = arrayList;
    }

    public void setDlType(int i2) {
        this.dlType = i2;
    }

    public Map<String, Object> getExtInfoMap() {
        return this.extInfoMap;
    }

    public void setExtInfoMap(Map<String, Object> map) {
        this.extInfoMap = map;
    }

    public String getCdnUrls() {
        AppMethodBeat.i(209883);
        if (this.urlList == null) {
            AppMethodBeat.o(209883);
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        boolean booleanValue = (this.extInfoMap == null || !this.extInfoMap.containsKey(TPDownloadProxyEnum.DLPARAM_ENABLE_EXPAND_DOWNLOAD_URL)) ? false : ((Boolean) this.extInfoMap.get(TPDownloadProxyEnum.DLPARAM_ENABLE_EXPAND_DOWNLOAD_URL)).booleanValue();
        for (int i2 = 0; i2 < this.urlList.size(); i2++) {
            stringBuffer.append(this.urlList.get(i2));
            if (booleanValue) {
                if (this.urlList.get(i2).indexOf("?") > 0) {
                    stringBuffer.append("&cost=low");
                } else {
                    stringBuffer.append("?cost=low");
                }
            }
            stringBuffer.append(";");
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(209883);
        return stringBuffer2;
    }

    public int getDlType() {
        return this.dlType;
    }

    public String getVid() {
        AppMethodBeat.i(209884);
        if (this.extInfoMap == null || this.extInfoMap.isEmpty()) {
            AppMethodBeat.o(209884);
            return "";
        }
        String str = "";
        if (this.extInfoMap.containsKey(TPDownloadProxyEnum.DLPARAM_VID)) {
            str = (String) this.extInfoMap.get(TPDownloadProxyEnum.DLPARAM_VID);
        }
        AppMethodBeat.o(209884);
        return str;
    }

    public boolean isOffline() {
        boolean z = false;
        AppMethodBeat.i(209885);
        if (this.extInfoMap == null || this.extInfoMap.isEmpty()) {
            AppMethodBeat.o(209885);
        } else {
            if (this.extInfoMap.containsKey(TPDownloadProxyEnum.DLPARAM_IS_OFFLINE)) {
                z = ((Boolean) this.extInfoMap.get(TPDownloadProxyEnum.DLPARAM_IS_OFFLINE)).booleanValue();
            }
            AppMethodBeat.o(209885);
        }
        return z;
    }

    public boolean isAdaptive() {
        boolean z;
        AppMethodBeat.i(209886);
        if (this.extInfoMap == null || this.extInfoMap.isEmpty()) {
            AppMethodBeat.o(209886);
            return false;
        }
        if (!this.extInfoMap.containsKey(TPDownloadProxyEnum.DLPARAM_ADAPTIVE_TYPE) || ((Integer) this.extInfoMap.get(TPDownloadProxyEnum.DLPARAM_ADAPTIVE_TYPE)).intValue() <= 0) {
            z = false;
        } else {
            z = true;
        }
        AppMethodBeat.o(209886);
        return z;
    }

    public Map<String, String> getOfflinePlayExtraInfo() {
        AppMethodBeat.i(209887);
        if (this.extInfoMap == null || this.extInfoMap.isEmpty()) {
            AppMethodBeat.o(209887);
            return null;
        } else if (this.extInfoMap.containsKey(TPDownloadProxyEnum.DLPARAM_OFFLINE_PLAY_EXTRA_INFO)) {
            Map<String, String> map = (Map) this.extInfoMap.get(TPDownloadProxyEnum.DLPARAM_OFFLINE_PLAY_EXTRA_INFO);
            AppMethodBeat.o(209887);
            return map;
        } else {
            AppMethodBeat.o(209887);
            return null;
        }
    }

    public String getPlayDefinition() {
        AppMethodBeat.i(209888);
        if (this.extInfoMap == null || this.extInfoMap.isEmpty()) {
            AppMethodBeat.o(209888);
            return "";
        }
        String str = "";
        if (this.extInfoMap.containsKey(TPDownloadProxyEnum.DLPARAM_PLAY_DEFINITION)) {
            str = (String) this.extInfoMap.get(TPDownloadProxyEnum.DLPARAM_PLAY_DEFINITION);
        }
        AppMethodBeat.o(209888);
        return str;
    }

    public String getFormat() {
        AppMethodBeat.i(209889);
        if (this.extInfoMap == null || this.extInfoMap.isEmpty()) {
            AppMethodBeat.o(209889);
            return "";
        }
        String str = "";
        if (this.extInfoMap.containsKey(TPDownloadProxyEnum.DLPARAM_CURRENT_FORMAT)) {
            str = (String) this.extInfoMap.get(TPDownloadProxyEnum.DLPARAM_CURRENT_FORMAT);
        }
        AppMethodBeat.o(209889);
        return str;
    }

    public String getKeyid() {
        AppMethodBeat.i(209890);
        if (this.extInfoMap == null || this.extInfoMap.isEmpty()) {
            AppMethodBeat.o(209890);
            return "";
        }
        String str = "";
        if (this.extInfoMap.containsKey(TPDownloadProxyEnum.DLPARAM_PLAY_KEYID)) {
            str = (String) this.extInfoMap.get(TPDownloadProxyEnum.DLPARAM_PLAY_KEYID);
        }
        AppMethodBeat.o(209890);
        return str;
    }

    public int getClipCount() {
        int i2 = 1;
        AppMethodBeat.i(209891);
        if (this.extInfoMap == null || this.extInfoMap.isEmpty()) {
            AppMethodBeat.o(209891);
        } else {
            if (this.extInfoMap.containsKey(TPDownloadProxyEnum.DLPARAM_PLAY_CLIP_COUNT)) {
                i2 = ((Integer) this.extInfoMap.get(TPDownloadProxyEnum.DLPARAM_PLAY_CLIP_COUNT)).intValue();
            }
            AppMethodBeat.o(209891);
        }
        return i2;
    }

    public int getClipNo() {
        int i2 = 1;
        AppMethodBeat.i(209892);
        if (this.extInfoMap == null || this.extInfoMap.isEmpty()) {
            AppMethodBeat.o(209892);
        } else {
            if (this.extInfoMap.containsKey(TPDownloadProxyEnum.DLPARAM_PLAY_CLIP_NO)) {
                i2 = ((Integer) this.extInfoMap.get(TPDownloadProxyEnum.DLPARAM_PLAY_CLIP_NO)).intValue();
            }
            AppMethodBeat.o(209892);
        }
        return i2;
    }

    public long getTotalDurationMS() {
        long j2 = 0;
        AppMethodBeat.i(209893);
        if (this.extInfoMap == null || this.extInfoMap.isEmpty()) {
            AppMethodBeat.o(209893);
        } else {
            if (this.extInfoMap.containsKey(TPDownloadProxyEnum.DLPARAM_FILE_DURATION)) {
                j2 = ((Long) this.extInfoMap.get(TPDownloadProxyEnum.DLPARAM_FILE_DURATION)).longValue();
            }
            AppMethodBeat.o(209893);
        }
        return j2;
    }

    public String getSavaPath() {
        AppMethodBeat.i(209894);
        if (this.extInfoMap == null || this.extInfoMap.isEmpty()) {
            AppMethodBeat.o(209894);
            return "";
        }
        String str = "";
        if (this.extInfoMap.containsKey(TPDownloadProxyEnum.DLPARAM_SAVE_PATH)) {
            str = (String) this.extInfoMap.get(TPDownloadProxyEnum.DLPARAM_SAVE_PATH);
        }
        AppMethodBeat.o(209894);
        return str;
    }

    public Object getExtInfo(String str) {
        AppMethodBeat.i(209895);
        if (this.extInfoMap == null) {
            AppMethodBeat.o(209895);
            return null;
        }
        Object obj = this.extInfoMap.get(str);
        AppMethodBeat.o(209895);
        return obj;
    }

    public String getExtraJsonInfo() {
        AppMethodBeat.i(209896);
        if (this.extInfoMap == null || this.extInfoMap.isEmpty()) {
            AppMethodBeat.o(209896);
            return "";
        }
        try {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, Object> entry : this.extInfoMap.entrySet()) {
                if (!entry.getKey().equalsIgnoreCase(TPDownloadProxyEnum.DLPARAM_IS_OFFLINE) && !entry.getKey().equalsIgnoreCase(TPDownloadProxyEnum.DLPARAM_OFFLINE_PLAY_EXTRA_INFO) && !entry.getKey().equalsIgnoreCase(TPDownloadProxyEnum.DLPARAM_PLAY_DEFINITION) && !entry.getKey().equalsIgnoreCase(TPDownloadProxyEnum.DLPARAM_ENABLE_EXPAND_DOWNLOAD_URL)) {
                    hashMap.put(entry.getKey(), entry.getValue());
                }
            }
            String jSONObject = new JSONObject(hashMap).toString();
            AppMethodBeat.o(209896);
            return jSONObject;
        } catch (Throwable th) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getExtraJsonInfo failed, error:" + th.toString());
            AppMethodBeat.o(209896);
            return "";
        }
    }

    private String getExtraFormatNodesJsonInfo(ArrayList<Map<String, Object>> arrayList) {
        AppMethodBeat.i(209897);
        if (arrayList == null) {
            AppMethodBeat.o(209897);
            return "[]";
        }
        try {
            StringBuffer stringBuffer = new StringBuffer("[");
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                Map<String, Object> map = arrayList.get(i2);
                if (i2 == arrayList.size() - 1) {
                    stringBuffer.append(String.format("{\"dl_param_name\":\"%s\", \"dl_param_bitrate\":%s}", map.get("dl_param_name"), map.get("dl_param_bitrate")));
                } else {
                    stringBuffer.append(String.format("{\"dl_param_name\":\"%s\", \"dl_param_bitrate\":%s}, ", map.get("dl_param_name"), map.get("dl_param_bitrate")));
                }
            }
            stringBuffer.append("]");
            String stringBuffer2 = stringBuffer.toString();
            AppMethodBeat.o(209897);
            return stringBuffer2;
        } catch (Throwable th) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getExtraJsonInfo failed, error:" + th.toString());
            AppMethodBeat.o(209897);
            return "[]";
        }
    }

    private String getUrlHostNodesJsonInfo(ArrayList<String> arrayList) {
        AppMethodBeat.i(209898);
        if (arrayList == null) {
            AppMethodBeat.o(209898);
            return "[]";
        }
        try {
            StringBuffer stringBuffer = new StringBuffer("[");
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                String str = arrayList.get(i2);
                if (i2 == arrayList.size() - 1) {
                    stringBuffer.append(String.format("\"%s\"", str));
                } else {
                    stringBuffer.append(String.format("\"%s\", ", str));
                }
            }
            stringBuffer.append("]");
            String stringBuffer2 = stringBuffer.toString();
            AppMethodBeat.o(209898);
            return stringBuffer2;
        } catch (Throwable th) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getArrayListStr failed, error:" + th.toString());
            AppMethodBeat.o(209898);
            return "[]";
        }
    }
}
