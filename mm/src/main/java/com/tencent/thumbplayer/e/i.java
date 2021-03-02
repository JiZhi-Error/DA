package com.tencent.thumbplayer.e;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadParam;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.thumbplayer.utils.b;
import com.tencent.thumbplayer.utils.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class i {
    static TPDownloadParam b(String str, TPDownloadParamData tPDownloadParamData) {
        TPDownloadParam tPDownloadParam;
        AppMethodBeat.i(189241);
        if (tPDownloadParamData != null) {
            ArrayList<String> arrayList = new ArrayList<>();
            if (tPDownloadParamData.getUrlCdnidList() == null || tPDownloadParamData.getUrlCdnidList().isEmpty()) {
                if (!TextUtils.isEmpty(str)) {
                    arrayList.add(str);
                } else {
                    arrayList.add(tPDownloadParamData.url);
                }
                String[] bakUrl = tPDownloadParamData.getBakUrl();
                if (bakUrl != null && bakUrl.length > 0) {
                    for (int i2 = 0; i2 < bakUrl.length; i2++) {
                        if (!TextUtils.isEmpty(bakUrl[i2])) {
                            arrayList.add(bakUrl[i2]);
                        }
                    }
                }
            } else {
                arrayList = tPDownloadParamData.getUrlCdnidList();
            }
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(tPDownloadParamData.getFlowId())) {
                g.i("TPProxyUtils", tPDownloadParamData.getFlowId());
                hashMap.put(TPDownloadProxyEnum.DLPARAM_PLAY_FLOWID, tPDownloadParamData.getFlowId());
            }
            if (!b.isEmpty(tPDownloadParamData.getUrlHostList())) {
                hashMap.put(TPDownloadProxyEnum.DLPARAM_URL_HOST, tPDownloadParamData.getUrlHostList());
            }
            if (!b.isEmpty(tPDownloadParamData.getUrlCookieList())) {
                hashMap.put(TPDownloadProxyEnum.DLPARAM_URL_COOKIE, tPDownloadParamData.getUrlCookieList());
            }
            if (tPDownloadParamData.getUrlExpireTime() > 0) {
                hashMap.put(TPDownloadProxyEnum.DLPARAM_URL_EXPIRE_TIME, Integer.valueOf(tPDownloadParamData.getUrlExpireTime()));
            }
            if (tPDownloadParamData.getFileSize() > 0) {
                hashMap.put(TPDownloadProxyEnum.DLPARAM_FILE_SIZE, Long.valueOf(tPDownloadParamData.getFileSize()));
            }
            if (tPDownloadParamData.getFileDuration() > 0) {
                hashMap.put(TPDownloadProxyEnum.DLPARAM_FILE_DURATION, Long.valueOf(tPDownloadParamData.getFileDuration()));
            }
            if (!TextUtils.isEmpty(tPDownloadParamData.getDownloadFileID())) {
                hashMap.put(TPDownloadProxyEnum.DLPARAM_PLAY_KEYID, tPDownloadParamData.getDownloadFileID());
            }
            if (!TextUtils.isEmpty(tPDownloadParamData.getVid())) {
                hashMap.put(TPDownloadProxyEnum.DLPARAM_VID, tPDownloadParamData.getVid());
            }
            if (!TextUtils.isEmpty(tPDownloadParamData.getPlayDefinition())) {
                hashMap.put(TPDownloadProxyEnum.DLPARAM_PLAY_DEFINITION, tPDownloadParamData.getPlayDefinition());
                hashMap.put(TPDownloadProxyEnum.DLPARAM_CURRENT_FORMAT, tPDownloadParamData.getPlayDefinition());
            }
            if (tPDownloadParamData.getCurrentFormatID() > 0) {
                hashMap.put(TPDownloadProxyEnum.DLPARAM_CURRENT_FORMATID, Integer.valueOf(tPDownloadParamData.getCurrentFormatID()));
            }
            if (!b.isEmpty(tPDownloadParamData.getFormatInfo())) {
                hashMap.put(TPDownloadProxyEnum.DLPARAM_FORMAT_INFO, tPDownloadParamData.getFormatInfo());
            }
            hashMap.put(TPDownloadProxyEnum.DLPARAM_SOURCE_IS_CHARGE, Boolean.valueOf(tPDownloadParamData.isCharge()));
            hashMap.put(TPDownloadProxyEnum.DLPARAM_CACHE_NEED_ENCRYPT, Boolean.valueOf(tPDownloadParamData.isNeedEncryptCache()));
            hashMap.put(TPDownloadProxyEnum.DLPARAM_IS_OFFLINE, Boolean.valueOf(tPDownloadParamData.isOffline()));
            hashMap.put(TPDownloadProxyEnum.DLPARAM_ENABLE_EXPAND_DOWNLOAD_URL, Boolean.valueOf(tPDownloadParamData.isExtraParam()));
            if (tPDownloadParamData.getPreloadSize() > 0) {
                hashMap.put(TPDownloadProxyEnum.DLPARAM_PRELOAD_SIZE, Long.valueOf(tPDownloadParamData.getPreloadSize()));
            }
            if (tPDownloadParamData.getPreloadDuration() > 0) {
                hashMap.put(TPDownloadProxyEnum.DLPARAM_PRELOAD_DURATION, Long.valueOf(tPDownloadParamData.getPreloadDuration()));
            }
            if (!TextUtils.isEmpty(tPDownloadParamData.getSavePath())) {
                hashMap.put(TPDownloadProxyEnum.DLPARAM_SAVE_PATH, tPDownloadParamData.getSavePath());
            }
            if (tPDownloadParamData.getStarTimeMS() > 0) {
                hashMap.put(TPDownloadProxyEnum.DLPARAM_PLAY_START_TIME, Integer.valueOf(tPDownloadParamData.getStarTimeMS()));
            }
            if (tPDownloadParamData.getEndTimeMS() > 0) {
                hashMap.put(TPDownloadProxyEnum.DLPARAM_PLAY_END_TIME, Integer.valueOf(tPDownloadParamData.getEndTimeMS()));
            }
            if (tPDownloadParamData.getClipCount() > 0) {
                hashMap.put(TPDownloadProxyEnum.DLPARAM_PLAY_CLIP_COUNT, Integer.valueOf(tPDownloadParamData.getClipCount()));
            }
            if (tPDownloadParamData.getClipNo() > 0) {
                hashMap.put(TPDownloadProxyEnum.DLPARAM_PLAY_CLIP_NO, Integer.valueOf(tPDownloadParamData.getClipNo()));
            }
            if (!TextUtils.isEmpty(tPDownloadParamData.getBase())) {
                hashMap.put(TPDownloadProxyEnum.DLPARAM_VINFO_BASE, tPDownloadParamData.getBase());
            }
            if (!TextUtils.isEmpty(tPDownloadParamData.getLinkVid())) {
                hashMap.put(TPDownloadProxyEnum.DLPARAM_VINFO_LINK_VID, tPDownloadParamData.getLinkVid());
            }
            if (!TextUtils.isEmpty(tPDownloadParamData.getFileMD5())) {
                hashMap.put(TPDownloadProxyEnum.DLPARAM_FILE_MD5, tPDownloadParamData.getFileMD5());
            }
            if (!TextUtils.isEmpty(tPDownloadParamData.getM3u8())) {
                hashMap.put(TPDownloadProxyEnum.DLPARAM_VINFO_M3U8, tPDownloadParamData.getM3u8());
            }
            if (tPDownloadParamData.getTm() > 0) {
                hashMap.put(TPDownloadProxyEnum.DLPARAM_VINFO_TM, Long.valueOf(tPDownloadParamData.getTm()));
            }
            if (tPDownloadParamData.getFp2p() > 0) {
                hashMap.put(TPDownloadProxyEnum.DLPARAM_VINFO_FP2P, Integer.valueOf(tPDownloadParamData.getFp2p()));
            }
            if (tPDownloadParamData.getTestid() > 0) {
                hashMap.put(TPDownloadProxyEnum.DLPARAM_VINFO_TESTID, Integer.valueOf(tPDownloadParamData.getTestid()));
            }
            if (tPDownloadParamData.getExceptDelay() > 0) {
                hashMap.put(TPDownloadProxyEnum.DLPARAM_EXPECT_DELAY_TIME, Integer.valueOf(tPDownloadParamData.getExceptDelay()));
            }
            if (!b.isEmpty(tPDownloadParamData.getExtInfoMap())) {
                hashMap.putAll(tPDownloadParamData.getExtInfoMap());
            }
            if (tPDownloadParamData.getSelfAdaption()) {
                hashMap.put(TPDownloadProxyEnum.DLPARAM_ADAPTIVE_TYPE, 3);
            } else {
                hashMap.put(TPDownloadProxyEnum.DLPARAM_ADAPTIVE_TYPE, 0);
            }
            hashMap.put(TPDownloadProxyEnum.DLPARAM_FORMAT_NODES, tPDownloadParamData.getDefInfoList());
            if (tPDownloadParamData.getPcdnUrlList() != null && !tPDownloadParamData.getPcdnUrlList().isEmpty()) {
                StringBuilder sb = new StringBuilder("");
                Iterator<String> it = tPDownloadParamData.getPcdnUrlList().iterator();
                while (it.hasNext()) {
                    sb.append(it.next());
                    sb.append(";");
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                g.i("TPProxyUtils", "pcdn url list: " + sb.toString());
                hashMap.put(TPDownloadProxyEnum.DLPARAM_PCDN_URLS, sb.toString());
            }
            if (tPDownloadParamData.getPcdnVtList() != null && !tPDownloadParamData.getPcdnVtList().isEmpty()) {
                StringBuilder sb2 = new StringBuilder("");
                Iterator<Integer> it2 = tPDownloadParamData.getPcdnVtList().iterator();
                while (it2.hasNext()) {
                    sb2.append(it2.next().intValue());
                    sb2.append(";");
                }
                if (sb2.length() > 0) {
                    sb2.deleteCharAt(sb2.length() - 1);
                }
                hashMap.put(TPDownloadProxyEnum.DLPARAM_PCDN_VTS, sb2.toString());
            }
            tPDownloadParam = new TPDownloadParam(arrayList, f.art(tPDownloadParamData.getDlType()), hashMap);
        } else {
            ArrayList arrayList2 = new ArrayList(1);
            arrayList2.add(str);
            tPDownloadParam = new TPDownloadParam(arrayList2, 0, null);
        }
        AppMethodBeat.o(189241);
        return tPDownloadParam;
    }
}
