package com.tencent.thumbplayer.e;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import com.tencent.thumbplayer.api.TPVideoInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.api.composition.ITPMediaDRMAsset;
import com.tencent.thumbplayer.api.composition.ITPMediaTrack;
import com.tencent.thumbplayer.api.composition.ITPMediaTrackClip;
import com.tencent.thumbplayer.api.proxy.ITPPlayerProxyListener;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadParam;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.thumbplayer.e.g;
import com.tencent.thumbplayer.utils.TPNetworkChangeMonitor;
import com.tencent.thumbplayer.utils.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c implements a, TPNetworkChangeMonitor.b, e.a {
    private static int RZu = -1;
    private LinkedList<b> RZA;
    private HashMap<String, Integer> RZB;
    private long RZC;
    private boolean RZD = false;
    private boolean RZE = false;
    private ITPDownloadProxy RZp;
    private boolean RZq = false;
    private int RZr = 3;
    private a RZs;
    private ITPPlayListener RZt;
    private ArrayList<TPDownloadParamData> RZv;
    private String RZw;
    private int RZx = -1;
    private TPVideoInfo RZy;
    private ITPPlayerProxyListener RZz = null;
    private long cwj;
    private Context mContext;
    private String mOriginUrl;
    private int mServiceType = RZu;

    public c(Context context) {
        AppMethodBeat.i(189169);
        this.mContext = context;
        e.a(this);
        TPNetworkChangeMonitor.hop().a(this);
        this.RZs = new a(this, (byte) 0);
        this.RZt = new d("TPThumbPlayer[TPPlayManagerImpl.java]");
        this.RZB = new HashMap<>();
        this.RZv = new ArrayList<>();
        AppMethodBeat.o(189169);
    }

    private void hny() {
        AppMethodBeat.i(189170);
        if (this.RZq) {
            AppMethodBeat.o(189170);
            return;
        }
        if (this.RZr > 0) {
            try {
                if (this.mServiceType == RZu) {
                    this.mServiceType = com.tencent.thumbplayer.d.a.hns();
                }
                b aru = g.a.RZS.aru(this.mServiceType);
                if (aru == null || aru.hnx() == null) {
                    this.RZr--;
                    com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p so load failed");
                    AppMethodBeat.o(189170);
                    return;
                }
                this.RZp = aru.hnx();
                this.RZp.setUserData(TPDownloadProxyEnum.USER_IS_VIP, Boolean.valueOf(com.tencent.thumbplayer.d.a.hnr()));
                if (!TextUtils.isEmpty(com.tencent.thumbplayer.d.a.hnn())) {
                    this.RZp.setUserData(TPDownloadProxyEnum.USER_UIN, com.tencent.thumbplayer.d.a.hnn());
                }
                if (!TextUtils.isEmpty(com.tencent.thumbplayer.d.a.getAppVersionName(this.mContext))) {
                    this.RZp.setUserData(TPDownloadProxyEnum.USER_APP_VERSION, com.tencent.thumbplayer.d.a.getAppVersionName(this.mContext));
                }
                if (com.tencent.thumbplayer.d.a.li(this.mContext) != -1) {
                    this.RZp.setUserData(TPDownloadProxyEnum.USER_APP_VERSION_CODE, String.valueOf(com.tencent.thumbplayer.d.a.li(this.mContext)));
                }
                this.RZp.setUserData(TPDownloadProxyEnum.USER_UPC, com.tencent.thumbplayer.d.a.hno());
                this.RZp.setUserData(TPDownloadProxyEnum.USER_UPC_STATE, Integer.valueOf(com.tencent.thumbplayer.d.a.hnp()));
                this.RZp.setUserData(TPDownloadProxyEnum.USER_EXTERNAL_NETWORK_IP, com.tencent.thumbplayer.d.a.hnq());
                this.RZq = true;
                AppMethodBeat.o(189170);
                return;
            } catch (Exception e2) {
                this.RZr--;
                com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", e2);
            }
        }
        AppMethodBeat.o(189170);
    }

    @Override // com.tencent.thumbplayer.e.a
    public final void a(ITPPlayListener iTPPlayListener) {
        this.RZt = iTPPlayListener;
    }

    @Override // com.tencent.thumbplayer.api.proxy.ITPPlayerProxy
    public final void setIsActive(boolean z) {
        AppMethodBeat.i(189171);
        com.tencent.thumbplayer.utils.g.d("TPThumbPlayer[TPPlayManagerImpl.java]", "setIsActive: ".concat(String.valueOf(z)));
        if (DW(false)) {
            AppMethodBeat.o(189171);
            return;
        }
        try {
            this.RZp.setPlayState(this.RZx, z ? 101 : 100);
            AppMethodBeat.o(189171);
        } catch (Throwable th) {
            com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", th);
            AppMethodBeat.o(189171);
        }
    }

    @Override // com.tencent.thumbplayer.e.a
    public final void DV(boolean z) {
        this.RZE = z;
    }

    @Override // com.tencent.thumbplayer.e.a
    public final com.tencent.thumbplayer.a.a.e bqC(String str) {
        TPDownloadParamData tPDownloadParamData;
        TPDownloadParam tPDownloadParam;
        AppMethodBeat.i(189172);
        com.tencent.thumbplayer.a.a.e eVar = new com.tencent.thumbplayer.a.a.e(str);
        if (!com.tencent.thumbplayer.utils.b.bnL(str)) {
            AppMethodBeat.o(189172);
            return eVar;
        } else if (DW(true)) {
            AppMethodBeat.o(189172);
            return eVar;
        } else {
            hnz();
            this.mOriginUrl = str;
            TPDownloadParamData e2 = e(this.RZv, 0);
            if (!this.RZE || e2 == null || e2.getDlType() != 1) {
                tPDownloadParamData = e2;
            } else {
                tPDownloadParamData = new TPDownloadParamData(11);
            }
            if (tPDownloadParamData != null) {
                tPDownloadParam = i.b(str, tPDownloadParamData);
            } else {
                tPDownloadParam = null;
            }
            try {
                com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "single url:" + str + ", paramData.savePath:" + (tPDownloadParamData != null ? tPDownloadParamData.getSavePath() : BuildConfig.COMMAND) + ", paramData.DownloadFileID:" + (tPDownloadParamData != null ? tPDownloadParamData.getDownloadFileID() : BuildConfig.COMMAND));
                this.RZx = this.RZp.startPlay(this.RZw, tPDownloadParam, this.RZs);
                if (this.RZx > 0) {
                    String playUrl = this.RZp.getPlayUrl(this.RZx, 0);
                    if (TextUtils.isEmpty(playUrl)) {
                        playUrl = str;
                    }
                    com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "startDownloadPlay, playId:" + this.RZx);
                    eVar.RWt = playUrl;
                    String playUrl2 = this.RZp.getPlayUrl(this.RZx, 1);
                    if (!TextUtils.isEmpty(playUrl2)) {
                        str = playUrl2;
                    }
                    eVar.RWs = str;
                } else {
                    com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy start play failed, cause : playId < 0");
                }
            } catch (Throwable th) {
                com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", th, "p2p proxy start play failed");
            }
            AppMethodBeat.o(189172);
            return eVar;
        }
    }

    private boolean nN(String str, String str2) {
        AppMethodBeat.i(189173);
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        HashMap hashMap = new HashMap();
        hashMap.put(TPDownloadProxyEnum.DLPARAM_DATA_TRANSFER_MODE, 1);
        boolean clipInfo = this.RZp.setClipInfo(this.RZx, 2, str2, new TPDownloadParam(arrayList, 3, hashMap));
        AppMethodBeat.o(189173);
        return clipInfo;
    }

    @Override // com.tencent.thumbplayer.e.a
    public final void nM(String str, String str2) {
        AppMethodBeat.i(189174);
        if (!com.tencent.thumbplayer.utils.b.bnL(str) || TextUtils.isEmpty(str2)) {
            Exception exc = new Exception("illegal argument.");
            AppMethodBeat.o(189174);
            throw exc;
        }
        if (this.RZD) {
            arr(this.RZx);
            bqC(this.mOriginUrl);
            if (!nN(str, str2)) {
                Exception exc2 = new Exception("setClipInfo err.");
                AppMethodBeat.o(189174);
                throw exc2;
            }
        } else if (!nN(str, str2)) {
            Exception exc3 = new Exception("setClipInfo err.");
            AppMethodBeat.o(189174);
            throw exc3;
        }
        this.RZD = true;
        AppMethodBeat.o(189174);
    }

    @Override // com.tencent.thumbplayer.e.a
    public final void hnt() {
        AppMethodBeat.i(189175);
        if (this.RZD) {
            arr(this.RZx);
            bqC(this.mOriginUrl);
        }
        this.RZD = false;
        AppMethodBeat.o(189175);
    }

    @Override // com.tencent.thumbplayer.e.a
    public final com.tencent.thumbplayer.a.a.e a(long j2, String str, TPVideoInfo tPVideoInfo) {
        AppMethodBeat.i(189176);
        if (tPVideoInfo == null) {
            com.tencent.thumbplayer.a.a.e eVar = new com.tencent.thumbplayer.a.a.e(str);
            AppMethodBeat.o(189176);
            return eVar;
        }
        TPDownloadParamData tPDownloadParamData = null;
        if (tPVideoInfo.getDownloadPraramList() != null) {
            tPDownloadParamData = tPVideoInfo.getDownloadPraramList().get(0);
        }
        com.tencent.thumbplayer.a.a.e a2 = a(j2, str, tPDownloadParamData);
        AppMethodBeat.o(189176);
        return a2;
    }

    private com.tencent.thumbplayer.a.a.e a(long j2, String str, TPDownloadParamData tPDownloadParamData) {
        String str2 = null;
        AppMethodBeat.i(189178);
        com.tencent.thumbplayer.a.a.e eVar = new com.tencent.thumbplayer.a.a.e(str);
        if (!com.tencent.thumbplayer.utils.b.bnL(str)) {
            AppMethodBeat.o(189178);
            return eVar;
        } else if (DW(false)) {
            AppMethodBeat.o(189178);
            return eVar;
        } else {
            if (this.RZA == null) {
                this.RZA = new LinkedList<>();
            }
            TPDownloadParam a2 = tPDownloadParamData != null ? a(str, tPDownloadParamData) : null;
            if (tPDownloadParamData != null) {
                try {
                    str2 = tPDownloadParamData.getDownloadFileID();
                } catch (Throwable th) {
                    com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", th, "p2p proxy switch def failed");
                }
            }
            int startPlay = this.RZp.startPlay(str2, a2, this.RZs);
            if (startPlay > 0) {
                String playUrl = this.RZp.getPlayUrl(startPlay, 1);
                if (TextUtils.isEmpty(playUrl)) {
                    playUrl = str;
                }
                eVar.RWt = playUrl;
                String playUrl2 = this.RZp.getPlayUrl(this.RZx, 0);
                if (!TextUtils.isEmpty(playUrl2)) {
                    str = playUrl2;
                }
                eVar.RWs = str;
                this.RZA.offer(new b(j2, startPlay));
                com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch def sucess, defId:" + j2 + ",playId:" + startPlay);
                AppMethodBeat.o(189178);
                return eVar;
            }
            com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch def failed, cause : playId < 0");
            AppMethodBeat.o(189178);
            return eVar;
        }
    }

    @Override // com.tencent.thumbplayer.e.a
    public final ITPMediaAsset b(ITPMediaAsset iTPMediaAsset) {
        AppMethodBeat.i(189181);
        if (DW(true)) {
            AppMethodBeat.o(189181);
        } else {
            hnz();
            if (iTPMediaAsset instanceof com.tencent.thumbplayer.c.g) {
                ((com.tencent.thumbplayer.c.g) iTPMediaAsset).setDrmPlayUrl(bqC(((com.tencent.thumbplayer.c.g) iTPMediaAsset).getDrmPlayUrl()).RWt);
                AppMethodBeat.o(189181);
            } else {
                List<ITPMediaTrackClip> c2 = c(iTPMediaAsset);
                if (!com.tencent.thumbplayer.utils.b.isEmpty(c2)) {
                    this.RZx = a(c2, this.RZw, this.RZv);
                }
                AppMethodBeat.o(189181);
            }
        }
        return iTPMediaAsset;
    }

    @Override // com.tencent.thumbplayer.e.a
    public final void pauseDownload() {
        AppMethodBeat.i(189182);
        arp(this.RZx);
        if (!com.tencent.thumbplayer.utils.b.isEmpty(this.RZA)) {
            Iterator<b> it = this.RZA.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null) {
                    arp(next.RZH);
                }
            }
        }
        if (!com.tencent.thumbplayer.utils.b.isEmpty(this.RZB)) {
            for (Integer num : this.RZB.values()) {
                arp(num.intValue());
            }
        }
        AppMethodBeat.o(189182);
    }

    @Override // com.tencent.thumbplayer.e.a
    public final void resumeDownload() {
        AppMethodBeat.i(189184);
        arq(this.RZx);
        if (!com.tencent.thumbplayer.utils.b.isEmpty(this.RZA)) {
            Iterator<b> it = this.RZA.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null) {
                    arq(next.RZH);
                }
            }
        }
        if (!com.tencent.thumbplayer.utils.b.isEmpty(this.RZB)) {
            for (Integer num : this.RZB.values()) {
                arq(num.intValue());
            }
        }
        AppMethodBeat.o(189184);
    }

    private static List<ITPMediaTrackClip> c(ITPMediaAsset iTPMediaAsset) {
        ITPMediaTrack iTPMediaTrack;
        AppMethodBeat.i(189186);
        if (iTPMediaAsset instanceof com.tencent.thumbplayer.c.b) {
            List<ITPMediaTrack> allAVTracks = ((com.tencent.thumbplayer.c.b) iTPMediaAsset).getAllAVTracks();
            if (!com.tencent.thumbplayer.utils.b.isEmpty(allAVTracks) && (iTPMediaTrack = allAVTracks.get(0)) != null && !com.tencent.thumbplayer.utils.b.isEmpty(iTPMediaTrack.getAllTrackClips())) {
                List<ITPMediaTrackClip> allTrackClips = iTPMediaTrack.getAllTrackClips();
                AppMethodBeat.o(189186);
                return allTrackClips;
            }
        } else if (iTPMediaAsset instanceof ITPMediaTrack) {
            ITPMediaTrack iTPMediaTrack2 = (ITPMediaTrack) iTPMediaAsset;
            if (!com.tencent.thumbplayer.utils.b.isEmpty(iTPMediaTrack2.getAllTrackClips())) {
                List<ITPMediaTrackClip> allTrackClips2 = iTPMediaTrack2.getAllTrackClips();
                AppMethodBeat.o(189186);
                return allTrackClips2;
            }
        } else if (iTPMediaAsset instanceof ITPMediaTrackClip) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add((ITPMediaTrackClip) iTPMediaAsset);
            AppMethodBeat.o(189186);
            return arrayList;
        }
        AppMethodBeat.o(189186);
        return null;
    }

    private int a(List<ITPMediaTrackClip> list, String str, ArrayList<TPDownloadParamData> arrayList) {
        int i2;
        AppMethodBeat.i(189187);
        if (com.tencent.thumbplayer.utils.b.isEmpty(list)) {
            com.tencent.thumbplayer.utils.g.w("TPThumbPlayer[TPPlayManagerImpl.java]", "clipList is empty, return");
            AppMethodBeat.o(189187);
            return -1;
        }
        int size = list.size();
        HashMap hashMap = new HashMap();
        int i3 = 0;
        int i4 = 1;
        while (i3 < size) {
            ITPMediaTrackClip iTPMediaTrackClip = list.get(i3);
            if (!(iTPMediaTrackClip instanceof com.tencent.thumbplayer.c.e) || !com.tencent.thumbplayer.utils.b.bnL(((com.tencent.thumbplayer.c.e) iTPMediaTrackClip).getFilePath())) {
                i2 = i4;
            } else {
                hashMap.put(iTPMediaTrackClip, new C2206c(i4, i3));
                i2 = i4 + 1;
            }
            i3++;
            i4 = i2;
        }
        if (com.tencent.thumbplayer.utils.b.isEmpty(hashMap)) {
            com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "all urls is local file url, return");
            AppMethodBeat.o(189187);
            return -1;
        }
        int startClipPlay = this.RZp.startClipPlay(str, hashMap.size(), this.RZs);
        if (startClipPlay > 0) {
            for (Map.Entry entry : hashMap.entrySet()) {
                ITPMediaTrackClip iTPMediaTrackClip2 = (ITPMediaTrackClip) entry.getKey();
                C2206c cVar = (C2206c) entry.getValue();
                if (iTPMediaTrackClip2 instanceof com.tencent.thumbplayer.c.e) {
                    com.tencent.thumbplayer.c.e eVar = (com.tencent.thumbplayer.c.e) iTPMediaTrackClip2;
                    TPDownloadParamData e2 = e(arrayList, cVar.RZJ);
                    if (e2 == null) {
                        com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", "fatal err, paramData is null.");
                        AppMethodBeat.o(189187);
                        return -1;
                    }
                    com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", "multi trackClipIndex:" + cVar.RZJ + ", download seq:" + cVar.RZI + ", clip.url:" + eVar.getUrl() + ", clip.getFilePath:" + eVar.getFilePath() + ", paramData.savePath:" + e2.getSavePath() + ", paramData.DownloadFileID:" + e2.getDownloadFileID());
                    if (this.RZp.setClipInfo(startClipPlay, cVar.RZI, e2.getDownloadFileID(), a(eVar.getFilePath(), e2))) {
                        eVar.RYW = this.RZp.getClipPlayUrl(startClipPlay, cVar.RZI, 1);
                    }
                }
            }
        } else {
            com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy start clip play failed, cause : playId < 0");
        }
        AppMethodBeat.o(189187);
        return startClipPlay;
    }

    @Override // com.tencent.thumbplayer.e.a
    public final void stopDownload() {
        AppMethodBeat.i(189188);
        if (this.RZx < 0) {
            com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "stopDownload failed, coz playId:" + this.RZx + ", less than zero. maybe download proxy didn't started");
            AppMethodBeat.o(189188);
            return;
        }
        com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "stopDownload, playId:" + this.RZx);
        arr(this.RZx);
        if (!com.tencent.thumbplayer.utils.b.isEmpty(this.RZA)) {
            Iterator<b> it = this.RZA.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null) {
                    arr(next.RZH);
                }
            }
            this.RZA.clear();
        }
        if (!com.tencent.thumbplayer.utils.b.isEmpty(this.RZB)) {
            for (Integer num : this.RZB.values()) {
                arr(num.intValue());
            }
            this.RZB.clear();
        }
        this.RZx = -1;
        com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "reset");
        this.RZw = "";
        this.mOriginUrl = "";
        this.RZy = null;
        this.cwj = 0;
        this.RZC = 0;
        this.RZD = false;
        if (!com.tencent.thumbplayer.utils.b.isEmpty(this.RZv)) {
            this.RZv.clear();
        }
        AppMethodBeat.o(189188);
    }

    @Override // com.tencent.thumbplayer.e.a
    public final void release() {
        AppMethodBeat.i(189189);
        stopDownload();
        TPNetworkChangeMonitor.hop().b(this);
        e.b(this);
        this.RZz = null;
        this.RZt = new d("TPThumbPlayer[TPPlayManagerImpl.java]");
        this.RZs = null;
        this.RZp = null;
        AppMethodBeat.o(189189);
    }

    @Override // com.tencent.thumbplayer.e.a
    public final ITPPlayerProxyListener hnw() {
        return this.RZz;
    }

    @Override // com.tencent.thumbplayer.e.a
    public final String a(int i2, String str, TPDownloadParamData tPDownloadParamData) {
        TPDownloadParam tPDownloadParam;
        int i3 = 0;
        AppMethodBeat.i(189196);
        if (TextUtils.isEmpty(str)) {
            com.tencent.thumbplayer.utils.g.w("TPThumbPlayer[TPPlayManagerImpl.java]", "return coz url is empty");
            AppMethodBeat.o(189196);
        } else if (!com.tencent.thumbplayer.utils.b.bnL(str)) {
            com.tencent.thumbplayer.utils.g.w("TPThumbPlayer[TPPlayManagerImpl.java]", "return coz url is locol url, not need use proxy");
            AppMethodBeat.o(189196);
        } else if (DW(false)) {
            com.tencent.thumbplayer.utils.g.w("TPThumbPlayer[TPPlayManagerImpl.java]", "return coz download proxy init failed");
            AppMethodBeat.o(189196);
        } else {
            if (tPDownloadParamData != null) {
                try {
                    tPDownloadParam = i.b(str, tPDownloadParamData);
                } catch (Throwable th) {
                    com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy start play failed:".concat(String.valueOf(th)));
                }
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                if (i2 == 3) {
                    i3 = 10;
                } else if (i2 == 2) {
                    i3 = 3;
                }
                tPDownloadParam = new TPDownloadParam(arrayList, i3, null);
            }
            int startPlay = this.RZp.startPlay(com.tencent.thumbplayer.utils.b.aSu(str), tPDownloadParam, this.RZs);
            if (startPlay > 0) {
                str = this.RZp.getPlayUrl(startPlay, 1);
                this.RZB.put(str, Integer.valueOf(startPlay));
            } else {
                com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy start play failed, cause : playId < 0");
            }
            AppMethodBeat.o(189196);
        }
        return str;
    }

    @Override // com.tencent.thumbplayer.e.a
    public final void aro(int i2) {
        AppMethodBeat.i(189197);
        com.tencent.thumbplayer.utils.g.d("TPThumbPlayer[TPPlayManagerImpl.java]", "setProxyPlayState: ".concat(String.valueOf(i2)));
        if (DW(false)) {
            AppMethodBeat.o(189197);
            return;
        }
        try {
            this.RZp.setPlayState(this.RZx, i2);
            if ((i2 == 5 || i2 == 0) && !com.tencent.thumbplayer.utils.b.isEmpty(this.RZA)) {
                Iterator<b> it = this.RZA.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    if (next != null) {
                        com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "setProxyPlayState definitionID:" + next.RZG + ", taskID:" + next.RZH + ", state:" + i2);
                        this.RZp.setPlayState(next.RZH, i2);
                    }
                }
            }
            AppMethodBeat.o(189197);
        } catch (Throwable th) {
            com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", th);
            AppMethodBeat.o(189197);
        }
    }

    @Override // com.tencent.thumbplayer.e.a
    public final void setVideoInfo(TPVideoInfo tPVideoInfo) {
        AppMethodBeat.i(189198);
        if (tPVideoInfo == null) {
            com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", "setVideoInfo, param is null ");
            AppMethodBeat.o(189198);
            return;
        }
        if (this.RZy != null && !DW(false)) {
            this.RZy = tPVideoInfo;
            if (tPVideoInfo == null || tPVideoInfo.getDownloadPraramList() == null) {
                com.tencent.thumbplayer.utils.g.w("TPThumbPlayer[TPPlayManagerImpl.java]", "video or downloadParamList is null, return");
            } else if (this.RZx <= 0) {
                com.tencent.thumbplayer.utils.g.w("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy not start, return");
            } else {
                ArrayList<TPDownloadParamData> downloadPraramList = tPVideoInfo.getDownloadPraramList();
                for (int i2 = 0; i2 < downloadPraramList.size(); i2++) {
                    TPDownloadParamData tPDownloadParamData = downloadPraramList.get(i2);
                    if (!this.RZp.setClipInfo(this.RZx, tPDownloadParamData.getClipNo(), tPDownloadParamData.getDownloadFileID(), i.b(tPDownloadParamData.getUrl(), tPDownloadParamData))) {
                        com.tencent.thumbplayer.utils.g.w("TPThumbPlayer[TPPlayManagerImpl.java]", "setClipInfo failed, playID:" + this.RZx + ", clipNo:" + tPDownloadParamData.getClipNo() + ", downloadFileID:" + tPDownloadParamData.getDownloadFileID());
                    }
                }
            }
        }
        this.RZy = tPVideoInfo;
        com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "setVideoInfo, enter");
        this.RZw = tPVideoInfo.getProxyFileID();
        if (!com.tencent.thumbplayer.utils.b.isEmpty(this.RZv)) {
            this.RZv.clear();
        }
        this.RZv.addAll(tPVideoInfo.getDownloadPraramList());
        AppMethodBeat.o(189198);
    }

    @Override // com.tencent.thumbplayer.api.proxy.ITPPlayerProxy
    public final void setProxyServiceType(int i2) {
        this.mServiceType = i2;
    }

    @Override // com.tencent.thumbplayer.api.proxy.ITPPlayerProxy
    public final void setTPPlayerProxyListener(ITPPlayerProxyListener iTPPlayerProxyListener) {
        this.RZz = iTPPlayerProxyListener;
    }

    private boolean DW(boolean z) {
        AppMethodBeat.i(189199);
        if (!com.tencent.thumbplayer.d.a.hnj()) {
            com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", "config set don't use p2p proxy!");
            AppMethodBeat.o(189199);
            return true;
        }
        if (z) {
            this.RZr = 3;
        }
        hny();
        if (!this.RZq) {
            AppMethodBeat.o(189199);
            return true;
        }
        AppMethodBeat.o(189199);
        return false;
    }

    private static TPDownloadParam a(String str, TPDownloadParamData tPDownloadParamData) {
        AppMethodBeat.i(258552);
        TPDownloadParam b2 = i.b(str, tPDownloadParamData);
        AppMethodBeat.o(258552);
        return b2;
    }

    private static TPDownloadParamData e(ArrayList<TPDownloadParamData> arrayList, int i2) {
        AppMethodBeat.i(189201);
        if (com.tencent.thumbplayer.utils.b.isEmpty(arrayList) || i2 >= arrayList.size()) {
            AppMethodBeat.o(189201);
            return null;
        }
        TPDownloadParamData tPDownloadParamData = arrayList.get(i2);
        AppMethodBeat.o(189201);
        return tPDownloadParamData;
    }

    private void hnz() {
        AppMethodBeat.i(189202);
        this.RZp.setUserData(TPDownloadProxyEnum.DLPARAM_PLAY_START_TIME, Long.valueOf(this.cwj));
        this.RZp.setUserData(TPDownloadProxyEnum.DLPARAM_PLAY_END_TIME, Long.valueOf(this.RZC));
        AppMethodBeat.o(189202);
    }

    @Override // com.tencent.thumbplayer.utils.TPNetworkChangeMonitor.b
    public final void my(int i2, int i3) {
        AppMethodBeat.i(189203);
        com.tencent.thumbplayer.utils.g.d("TPThumbPlayer[TPPlayManagerImpl.java]", "onNetworkStatusChanged oldNetStatus: " + i2 + ", netStatus: " + i3);
        if (i3 == 1) {
            ars(1);
            ars(10);
            AppMethodBeat.o(189203);
        } else if (i3 == 2) {
            ars(2);
            ars(9);
            AppMethodBeat.o(189203);
        } else {
            if (i3 == 3) {
                ars(2);
                ars(10);
            }
            AppMethodBeat.o(189203);
        }
    }

    @Override // com.tencent.thumbplayer.utils.e.a
    public final void d(int i2, int i3, int i4, Object obj) {
        AppMethodBeat.i(189204);
        com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "onEvent eventId: " + i2 + ", arg1: " + i3 + ", arg2: " + i4 + ", object" + obj);
        switch (i2) {
            case TPPlayerMgr.EVENT_ID_APP_ENTER_BACKGROUND:
                ars(13);
                AppMethodBeat.o(189204);
                return;
            case TPPlayerMgr.EVENT_ID_APP_ENTER_FOREGROUND:
                ars(14);
                break;
        }
        AppMethodBeat.o(189204);
    }

    /* access modifiers changed from: package-private */
    public class a implements ITPPlayListener {
        private a() {
        }

        /* synthetic */ a(c cVar, byte b2) {
            this();
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public final void onDownloadProgressUpdate(int i2, int i3, long j2, long j3, String str) {
            AppMethodBeat.i(189148);
            c.this.RZt.onDownloadProgressUpdate(i2, i3, j2, j3, str);
            AppMethodBeat.o(189148);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public final void onDownloadFinish() {
            AppMethodBeat.i(189149);
            c.this.RZt.onDownloadFinish();
            AppMethodBeat.o(189149);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public final void onDownloadError(int i2, int i3, String str) {
            AppMethodBeat.i(189150);
            c.this.RZt.onDownloadError(i2, i3, str);
            AppMethodBeat.o(189150);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public final void onDownloadCdnUrlUpdate(String str) {
            AppMethodBeat.i(189151);
            c.this.RZt.onDownloadCdnUrlUpdate(str);
            AppMethodBeat.o(189151);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public final void onDownloadCdnUrlInfoUpdate(String str, String str2, String str3, String str4) {
            AppMethodBeat.i(189152);
            c.this.RZt.onDownloadCdnUrlInfoUpdate(str, str2, str3, str4);
            AppMethodBeat.o(189152);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public final void onDownloadStatusUpdate(int i2) {
            AppMethodBeat.i(189153);
            c.this.RZt.onDownloadStatusUpdate(i2);
            AppMethodBeat.o(189153);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public final void onDownloadProtocolUpdate(String str, String str2) {
            AppMethodBeat.i(189154);
            c.this.RZt.onDownloadProtocolUpdate(str, str2);
            AppMethodBeat.o(189154);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public final void onDownloadCdnUrlExpired(Map<String, String> map) {
            AppMethodBeat.i(189155);
            c.this.RZt.onDownloadCdnUrlExpired(map);
            AppMethodBeat.o(189155);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public final Object onPlayCallback(int i2, Object obj, Object obj2, Object obj3, Object obj4) {
            AppMethodBeat.i(189156);
            Object onPlayCallback = c.this.RZt.onPlayCallback(i2, obj, obj2, obj3, obj4);
            AppMethodBeat.o(189156);
            return onPlayCallback;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public final long getPlayerBufferLength() {
            AppMethodBeat.i(189157);
            long playerBufferLength = c.this.RZt.getPlayerBufferLength();
            AppMethodBeat.o(189157);
            return playerBufferLength;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public final long getCurrentPosition() {
            AppMethodBeat.i(189158);
            long currentPosition = c.this.RZt.getCurrentPosition();
            AppMethodBeat.o(189158);
            return currentPosition;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public final int getCurrentPlayClipNo() {
            AppMethodBeat.i(189159);
            int currentPlayClipNo = c.this.RZt.getCurrentPlayClipNo();
            AppMethodBeat.o(189159);
            return currentPlayClipNo;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public final long getAdvRemainTime() {
            AppMethodBeat.i(189160);
            long advRemainTime = c.this.RZt.getAdvRemainTime();
            AppMethodBeat.o(189160);
            return advRemainTime;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public final Object getPlayInfo(long j2) {
            AppMethodBeat.i(189161);
            Object playInfo = c.this.RZt.getPlayInfo(j2);
            AppMethodBeat.o(189161);
            return playInfo;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public final Object getPlayInfo(String str) {
            AppMethodBeat.i(189162);
            Object playInfo = c.this.RZt.getPlayInfo(str);
            AppMethodBeat.o(189162);
            return playInfo;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public final int onStartReadData(int i2, String str, long j2, long j3) {
            AppMethodBeat.i(189163);
            int onStartReadData = c.this.RZt.onStartReadData(i2, str, j2, j3);
            AppMethodBeat.o(189163);
            return onStartReadData;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public final int onReadData(int i2, String str, long j2, long j3) {
            AppMethodBeat.i(189164);
            int onReadData = c.this.RZt.onReadData(i2, str, j2, j3);
            AppMethodBeat.o(189164);
            return onReadData;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public final int onStopReadData(int i2, String str, int i3) {
            AppMethodBeat.i(189165);
            int onStopReadData = c.this.RZt.onStopReadData(i2, str, i3);
            AppMethodBeat.o(189165);
            return onStopReadData;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public final long getDataTotalSize(int i2, String str) {
            AppMethodBeat.i(189166);
            long dataTotalSize = c.this.RZt.getDataTotalSize(i2, str);
            AppMethodBeat.o(189166);
            return dataTotalSize;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public final String getDataFilePath(int i2, String str) {
            AppMethodBeat.i(189167);
            String dataFilePath = c.this.RZt.getDataFilePath(i2, str);
            AppMethodBeat.o(189167);
            return dataFilePath;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public final String getContentType(int i2, String str) {
            AppMethodBeat.i(189168);
            String contentType = c.this.RZt.getContentType(i2, str);
            AppMethodBeat.o(189168);
            return contentType;
        }
    }

    /* access modifiers changed from: package-private */
    public static class b {
        long RZG;
        int RZH;

        b(long j2, int i2) {
            this.RZG = j2;
            this.RZH = i2;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.thumbplayer.e.c$c  reason: collision with other inner class name */
    public static class C2206c {
        int RZI;
        int RZJ;

        C2206c(int i2, int i3) {
            this.RZI = i2;
            this.RZJ = i3;
        }
    }

    @Override // com.tencent.thumbplayer.e.a
    public final ITPMediaAsset a(ITPMediaAsset iTPMediaAsset, long j2, TPVideoInfo tPVideoInfo) {
        TPDownloadParamData tPDownloadParamData;
        AppMethodBeat.i(189177);
        if (DW(false) || iTPMediaAsset == null) {
            AppMethodBeat.o(189177);
        } else {
            if (this.RZA == null) {
                this.RZA = new LinkedList<>();
            }
            if (tPVideoInfo == null) {
                AppMethodBeat.o(189177);
            } else if (iTPMediaAsset instanceof ITPMediaDRMAsset) {
                if (tPVideoInfo.getDownloadPraramList() != null) {
                    tPDownloadParamData = tPVideoInfo.getDownloadPraramList().get(0);
                } else {
                    tPDownloadParamData = null;
                }
                ((com.tencent.thumbplayer.c.g) iTPMediaAsset).setDrmPlayUrl(a(j2, ((ITPMediaDRMAsset) iTPMediaAsset).getDrmPlayUrl(), tPDownloadParamData).RWt);
                AppMethodBeat.o(189177);
            } else {
                List<ITPMediaTrackClip> c2 = c(iTPMediaAsset);
                if (!com.tencent.thumbplayer.utils.b.isEmpty(c2) && tPVideoInfo != null) {
                    int a2 = a(c2, tPVideoInfo.getProxyFileID(), tPVideoInfo.getDownloadPraramList());
                    if (a2 > 0) {
                        this.RZA.offer(new b(j2, a2));
                        com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch def sucess, defId:" + j2 + ",playId:" + a2);
                        AppMethodBeat.o(189177);
                    } else {
                        com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch clip def failed, cause : playId < 0");
                    }
                }
                AppMethodBeat.o(189177);
            }
        }
        return iTPMediaAsset;
    }

    @Override // com.tencent.thumbplayer.e.a
    public final void OE(long j2) {
        AppMethodBeat.i(189179);
        if (DW(false)) {
            AppMethodBeat.o(189179);
            return;
        }
        try {
            if (!com.tencent.thumbplayer.utils.b.isEmpty(this.RZA)) {
                b peek = this.RZA.peek();
                while (peek != null && peek.RZG != j2) {
                    com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "stop proxy definitionID:" + peek.RZG + ", taskID:" + peek.RZH);
                    arr(peek.RZH);
                    this.RZA.removeFirst();
                    peek = this.RZA.peek();
                }
                if (peek != null) {
                    com.tencent.thumbplayer.utils.g.i("TPThumbPlayer[TPPlayManagerImpl.java]", "stop proxy task id:" + peek.RZH);
                    arr(this.RZx);
                    this.RZx = peek.RZH;
                    this.RZA.remove(peek);
                }
            }
            AppMethodBeat.o(189179);
        } catch (Exception e2) {
            com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", e2, "playerSwitchDefComplete exception");
            AppMethodBeat.o(189179);
        }
    }

    @Override // com.tencent.thumbplayer.e.a
    public final boolean hnu() {
        AppMethodBeat.i(189180);
        if (DW(false)) {
            AppMethodBeat.o(189180);
            return false;
        } else if (this.RZA == null || this.RZA.size() <= 0) {
            AppMethodBeat.o(189180);
            return false;
        } else {
            AppMethodBeat.o(189180);
            return true;
        }
    }

    private void arp(int i2) {
        AppMethodBeat.i(189183);
        if (DW(false)) {
            AppMethodBeat.o(189183);
            return;
        }
        try {
            this.RZp.pauseDownload(i2);
            AppMethodBeat.o(189183);
        } catch (Throwable th) {
            com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", th, "p2p proxy pause download failed, taskId:".concat(String.valueOf(i2)));
            AppMethodBeat.o(189183);
        }
    }

    private void arq(int i2) {
        AppMethodBeat.i(189185);
        if (DW(false)) {
            AppMethodBeat.o(189185);
            return;
        }
        try {
            this.RZp.resumeDownload(this.RZx);
            AppMethodBeat.o(189185);
        } catch (Throwable th) {
            com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", th, "p2p proxy resume download failed, taskId:".concat(String.valueOf(i2)));
            AppMethodBeat.o(189185);
        }
    }

    private void arr(int i2) {
        AppMethodBeat.i(189190);
        if (DW(false)) {
            AppMethodBeat.o(189190);
            return;
        }
        try {
            this.RZp.stopPlay(i2);
            AppMethodBeat.o(189190);
        } catch (Throwable th) {
            com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", th, "p2p proxy stop play failed, taskID:".concat(String.valueOf(i2)));
            AppMethodBeat.o(189190);
        }
    }

    private void ars(int i2) {
        AppMethodBeat.i(189191);
        if (DW(false)) {
            AppMethodBeat.o(189191);
            return;
        }
        try {
            this.RZp.pushEvent(i2);
            AppMethodBeat.o(189191);
        } catch (Throwable th) {
            com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", th, "p2p proxy pushEvent failed, event:".concat(String.valueOf(i2)));
            AppMethodBeat.o(189191);
        }
    }

    @Override // com.tencent.thumbplayer.api.proxy.ITPPlayerProxy
    public final void pushEvent(int i2) {
        int i3;
        AppMethodBeat.i(189192);
        if (DW(false)) {
            AppMethodBeat.o(189192);
            return;
        }
        switch (i2) {
            case 3:
                i3 = 3;
                break;
            case 4:
                i3 = 4;
                break;
            case 5:
                i3 = 5;
                break;
            case 6:
                i3 = 6;
                break;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            default:
                try {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("event is invalid : ".concat(String.valueOf(i2)));
                    AppMethodBeat.o(189192);
                    throw illegalArgumentException;
                } catch (IllegalArgumentException e2) {
                    com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", e2);
                    AppMethodBeat.o(189192);
                    return;
                }
            case 13:
                i3 = 13;
                break;
            case 14:
                i3 = 14;
                break;
            case 15:
                i3 = 15;
                break;
            case 16:
                i3 = 16;
                break;
            case 17:
                i3 = 17;
                break;
            case 18:
                i3 = 18;
                break;
            case 19:
                i3 = 19;
                break;
            case 20:
                i3 = 20;
                break;
            case 21:
                i3 = 21;
                break;
        }
        ars(i3);
        AppMethodBeat.o(189192);
    }

    @Override // com.tencent.thumbplayer.e.a
    public final boolean isEnable() {
        AppMethodBeat.i(189193);
        if (!DW(false)) {
            AppMethodBeat.o(189193);
            return true;
        }
        AppMethodBeat.o(189193);
        return false;
    }

    @Override // com.tencent.thumbplayer.e.a
    public final String hnv() {
        String str = null;
        AppMethodBeat.i(189194);
        if (DW(false)) {
            AppMethodBeat.o(189194);
        } else {
            try {
                str = this.RZp.getPlayErrorCodeStr(this.RZx);
                AppMethodBeat.o(189194);
            } catch (Throwable th) {
                com.tencent.thumbplayer.utils.g.e("TPThumbPlayer[TPPlayManagerImpl.java]", th);
                AppMethodBeat.o(189194);
            }
        }
        return str;
    }

    @Override // com.tencent.thumbplayer.e.a
    public final void setPlayerOptionalParam(TPOptionalParam tPOptionalParam) {
        AppMethodBeat.i(189195);
        if (DW(false)) {
            AppMethodBeat.o(189195);
        } else if (tPOptionalParam == null || tPOptionalParam.getKey() != 100) {
            if (tPOptionalParam != null && tPOptionalParam.getKey() == 500) {
                this.RZC = tPOptionalParam.getParamLong().value;
                if (this.RZx > 0) {
                    this.RZp.setUserData(TPDownloadProxyEnum.DLPARAM_PLAY_END_TIME, Long.valueOf(this.RZC));
                }
            }
            AppMethodBeat.o(189195);
        } else {
            this.cwj = tPOptionalParam.getParamLong().value;
            AppMethodBeat.o(189195);
        }
    }
}
