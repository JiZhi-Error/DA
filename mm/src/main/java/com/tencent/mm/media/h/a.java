package com.tencent.mm.media.h;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 ;2\u00020\u0001:\u0001;Bw\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u00128\u0010\u000b\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n0\f¢\u0006\u0002\u0010\u0013J\b\u0010/\u001a\u00020\nH\u0002J.\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\r2\u0006\u00102\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u0003J\u000e\u00104\u001a\u00020\n2\u0006\u00102\u001a\u00020\u0015J\u0010\u00105\u001a\u00020\u00062\u0006\u00101\u001a\u00020\rH\u0002J\b\u00106\u001a\u00020\nH\u0002J\u0006\u00107\u001a\u00020\nJ\u0006\u00108\u001a\u00020\nJ0\u00109\u001a\u00020\u00192\u0006\u0010:\u001a\u00020\r2\u0006\u00102\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0002R\u000e\u0010\u0014\u001a\u00020\u0015XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R2\u0010\u0017\u001a&\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00190\u0019 \u001a*\u0012\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00190\u0019\u0018\u00010\u001b0\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u000e¢\u0006\u0002\n\u0000R@\u0010\u000b\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n0\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R2\u0010-\u001a&\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00190\u0019 \u001a*\u0012\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00190\u0019\u0018\u00010\u001b0\u0018X\u000e¢\u0006\u0002\n\u0000R2\u0010.\u001a&\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00190\u0019 \u001a*\u0012\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00190\u0019\u0018\u00010\u001b0\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, hxF = {"Lcom/tencent/mm/media/mix/AudioMixCodec;", "", "sampleRate", "", WeChatBrands.Business.GROUP_CHANNELS, "mixBackground", "", "mixMusic", "frameMix", "Lkotlin/Function0;", "", "frameMixEnd", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "data", "", "pts", "(IIZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;)V", "TAG", "", "backgroundFrameCount", "backgroundPcmDataList", "", "Lcom/tencent/mm/audio/mix/buffer/PcmDataTrack;", "kotlin.jvm.PlatformType", "", "bitDepth", "flushAllData", "flushLock", "Ljava/lang/Object;", "frameLength", FirebaseAnalytics.b.INDEX, "isBackgroundEnd", "isMixing", "isMixingFinish", "isMusicEnd", "mAudioSyncMixController", "Lcom/tencent/mm/audio/mix/mix/AudioSyncMixController;", "mMixRunnable", "Ljava/lang/Runnable;", "mPts", "mixLock", "musicFrameCount", "musicPcmDataList", "pcmDataList", "getAudioData", "input", "pcmData", "audioId", "channelCount", "inputEnd", "isAllPcmZero", "runMix", "startMix", "stopMix", "zipPcmDataTrack", "buffer", "Companion", "plugin-mediaeditor_release"})
public final class a {
    public static final C0416a igT = new C0416a((byte) 0);
    public final String TAG = "MicroMsg.AudioMixCodec";
    private int channels;
    private final int dtP = 2;
    private final int igA = 2048;
    public long igB;
    private List<e> igC = Collections.synchronizedList(new ArrayList());
    private List<e> igD = Collections.synchronizedList(new ArrayList());
    public final List<e> igE = Collections.synchronizedList(new ArrayList());
    public volatile boolean igF;
    public volatile boolean igG;
    public volatile boolean igH;
    public final Object igI = new Object();
    public final Object igJ = new Object();
    private int igK;
    private int igL;
    private boolean igM;
    private boolean igN;
    private final Runnable igO;
    private boolean igP;
    private final boolean igQ;
    private kotlin.g.a.a<x> igR;
    public m<? super byte[], ? super Long, x> igS;
    public final com.tencent.mm.audio.mix.f.e igz = new com.tencent.mm.audio.mix.f.e();
    private int index;
    private int sampleRate;

    static {
        AppMethodBeat.i(93714);
        AppMethodBeat.o(93714);
    }

    public a(int i2, int i3, boolean z, boolean z2, kotlin.g.a.a<x> aVar, m<? super byte[], ? super Long, x> mVar) {
        p.h(aVar, "frameMix");
        p.h(mVar, "frameMixEnd");
        AppMethodBeat.i(93713);
        this.sampleRate = i2;
        this.channels = i3;
        this.igP = z;
        this.igQ = z2;
        this.igR = aVar;
        this.igS = mVar;
        Log.i(this.TAG, "init AudioMixCodec, sampleRate:" + this.sampleRate + ", channels:" + this.channels + ", mixBackground:" + this.igP + ", mixMusic:" + this.igQ);
        this.igz.r(this.sampleRate, this.channels, this.dtP, this.igA * this.channels);
        this.igO = new b(this);
        AppMethodBeat.o(93713);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/media/mix/AudioMixCodec$Companion;", "", "()V", "BACKGROUND", "", "BATCH_MIX_NUM", "", "MIX_ALL", "MIX_BACKGROUND", "MIX_MUSIC", "MIX_SILENT", "MUSIC", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.h.a$a  reason: collision with other inner class name */
    public static final class C0416a {
        private C0416a() {
        }

        public /* synthetic */ C0416a(byte b2) {
            this();
        }
    }

    public final void Hm(String str) {
        boolean z = true;
        AppMethodBeat.i(93711);
        p.h(str, "audioId");
        synchronized (this.igI) {
            try {
                Log.i(this.TAG, "inputEnd, audioId:" + str + ", mixBackground:" + this.igP + ", mixMusic:" + this.igQ);
                if (p.j(str, "background")) {
                    this.igM = true;
                }
                if (p.j(str, "music")) {
                    this.igN = true;
                }
                if (!this.igP || !this.igQ) {
                    if ((!this.igP || !this.igM) && (!this.igQ || !this.igN)) {
                        z = false;
                    }
                } else if (!this.igN || !this.igM) {
                    z = false;
                }
                if (z) {
                    try {
                        this.igH = true;
                        Log.i(this.TAG, "notify mix");
                        this.igI.notifyAll();
                    } catch (Exception e2) {
                    }
                }
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(93711);
            }
        }
    }

    public final boolean a(byte[] bArr, String str, long j2, int i2, int i3) {
        AppMethodBeat.i(93712);
        p.h(bArr, "pcmData");
        p.h(str, "audioId");
        synchronized (this.igI) {
            try {
                Log.i(this.TAG, "pcmData len:" + bArr.length + ", audioId:" + str + ", sampleRate:" + i2 + ", channelCount:" + i3 + ", pts:" + j2);
                e eVar = new e();
                eVar.dtX = str;
                eVar.dtQ = bArr;
                eVar.sampleRate = i2;
                eVar.channels = i3;
                eVar.dua = j2;
                switch (str.hashCode()) {
                    case -1332194002:
                        if (str.equals("background")) {
                            Log.i(this.TAG, "input the background data num = " + this.igC.size());
                            this.igC.add(eVar);
                            String str2 = this.TAG;
                            StringBuilder sb = new StringBuilder("input background data:");
                            int i4 = this.igK;
                            this.igK = i4 + 1;
                            Log.i(str2, sb.append(i4).toString());
                            break;
                        }
                        break;
                    case 104263205:
                        if (str.equals("music")) {
                            Log.i(this.TAG, "input the music data num = " + this.igD.size());
                            this.igD.add(eVar);
                            String str3 = this.TAG;
                            StringBuilder sb2 = new StringBuilder("input music data:");
                            int i5 = this.igL;
                            this.igL = i5 + 1;
                            Log.i(str3, sb2.append(i5).toString());
                            break;
                        }
                        break;
                }
                if (!this.igQ || !this.igP) {
                    if ((this.igQ || this.igP) && (this.igD.size() > 0 || this.igC.size() > 0)) {
                        try {
                            Log.i(this.TAG, "notify mix");
                            this.igI.notifyAll();
                        } catch (Exception e2) {
                        }
                    }
                    try {
                        x xVar = x.SXb;
                    } catch (Throwable th) {
                        AppMethodBeat.o(93712);
                        throw th;
                    }
                } else {
                    if (this.igD.size() > 0 && this.igC.size() > 0) {
                        try {
                            Log.i(this.TAG, "notify mix");
                            this.igI.notifyAll();
                        } catch (Exception e3) {
                        }
                    }
                    x xVar2 = x.SXb;
                }
            } catch (Exception e4) {
                Log.printErrStackTrace(this.TAG, e4, "", new Object[0]);
                com.tencent.mm.media.k.e eVar2 = com.tencent.mm.media.k.e.ilC;
                com.tencent.mm.media.k.e.aOF();
            }
        }
        AppMethodBeat.o(93712);
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ a igU;

        b(a aVar) {
            this.igU = aVar;
        }

        public final void run() {
            AppMethodBeat.i(93709);
            while (this.igU.igG) {
                try {
                    synchronized (this.igU.igI) {
                        try {
                            this.igU.igI.wait();
                            x xVar = x.SXb;
                        } finally {
                            AppMethodBeat.o(93709);
                        }
                    }
                    Log.i(this.igU.TAG, "mixBackground:" + this.igU.igP + ", mixMusic:" + this.igU.igQ + ", music:" + this.igU.igD.size() + ", background:" + this.igU.igC.size());
                    synchronized (this.igU.igJ) {
                        do {
                            try {
                                if (this.igU.igC.size() > 0 || this.igU.igD.size() > 0) {
                                    if (!this.igU.igP || !this.igU.igQ) {
                                        if (this.igU.igP || this.igU.igQ) {
                                            this.igU.igR.invoke();
                                            for (int i2 = 0; i2 <= 0; i2++) {
                                                a.l(this.igU);
                                                a.m(this.igU);
                                            }
                                            if (this.igU.igQ) {
                                                if (this.igU.igD.size() <= 0) {
                                                    break;
                                                }
                                            }
                                            if (this.igU.igP && this.igU.igC.size() <= 0) {
                                                break;
                                            }
                                        }
                                    } else {
                                        if (this.igU.igC.size() <= 0 || this.igU.igD.size() <= 0) {
                                            break;
                                        }
                                        this.igU.igR.invoke();
                                        for (int i3 = 0; i3 <= 0; i3++) {
                                            a.l(this.igU);
                                            a.m(this.igU);
                                        }
                                    }
                                } else {
                                    break;
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        } while (this.igU.igH);
                        if (this.igU.igH) {
                            Log.i(this.igU.TAG, "flush data finish");
                            this.igU.igG = false;
                            this.igU.igF = true;
                            this.igU.igJ.notifyAll();
                        }
                        x xVar2 = x.SXb;
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace(this.igU.TAG, e2, "", new Object[0]);
                    com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
                    com.tencent.mm.media.k.e.aOF();
                }
            }
            Log.i(this.igU.TAG, "finish mix");
            AppMethodBeat.o(93709);
        }
    }

    private static boolean af(byte[] bArr) {
        boolean z;
        boolean z2;
        int length = bArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = false;
                break;
            }
            if (bArr[i2] != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                z = true;
                break;
            }
            i2++;
        }
        return !z;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ a igU;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(a aVar) {
            super(0);
            this.igU = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(93710);
            this.igU.igO.run();
            x xVar = x.SXb;
            AppMethodBeat.o(93710);
            return xVar;
        }
    }

    public static final /* synthetic */ void l(a aVar) {
        AppMethodBeat.i(93715);
        List<e> list = aVar.igE;
        p.g(list, "pcmDataList");
        synchronized (list) {
            try {
                aVar.igE.clear();
                Log.i(aVar.TAG, "getAudioData, background:" + aVar.igC.size() + ", music:" + aVar.igD.size());
                if (aVar.igP && aVar.igC.size() > 0) {
                    e eVar = aVar.igC.get(0);
                    byte[] bArr = eVar.dtQ;
                    p.g(bArr, "backPcm.pcmData");
                    if (!af(bArr) || (aVar.igP && !aVar.igQ)) {
                        aVar.igE.add(eVar);
                    } else {
                        Log.i(aVar.TAG, "getAudioData background data zero");
                    }
                    aVar.igC.remove(eVar);
                }
                if (aVar.igQ && aVar.igD.size() > 0) {
                    e eVar2 = aVar.igD.get(0);
                    aVar.igE.add(eVar2);
                    aVar.igD.remove(eVar2);
                }
                String str = aVar.TAG;
                StringBuilder sb = new StringBuilder("get audio data num ");
                int i2 = aVar.index;
                aVar.index = i2 + 1;
                Log.i(str, sb.append(i2).toString());
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(93715);
            }
        }
    }

    public static final /* synthetic */ void m(a aVar) {
        long j2;
        AppMethodBeat.i(93716);
        List<e> list = aVar.igE;
        p.g(list, "pcmDataList");
        synchronized (list) {
            try {
                Log.i(aVar.TAG, "the mix thread running mix " + aVar.index + " pcmDataListSize: " + aVar.igE.size() + ", mixBackground:" + aVar.igP + ", mixMusic:" + aVar.igQ);
                if (aVar.igE.size() > 0) {
                    long currentTicks = Util.currentTicks();
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(aVar.igE);
                    byte[] Q = aVar.igz.Q(arrayList);
                    if (Q != null) {
                        long j3 = 0;
                        if (aVar.igQ) {
                            List<e> list2 = aVar.igE;
                            p.g(list2, "pcmDataList");
                            List<e> list3 = list2;
                            synchronized (list3) {
                                try {
                                    for (T t : list3) {
                                        if (p.j(t.dtX, "music")) {
                                            j3 = t.dua;
                                            Log.i(aVar.TAG, "get pts from music: ".concat(String.valueOf(j3)));
                                        }
                                    }
                                    x xVar = x.SXb;
                                } catch (Throwable th) {
                                    AppMethodBeat.o(93716);
                                    throw th;
                                }
                            }
                            j2 = j3;
                        } else if (!aVar.igP || aVar.igQ) {
                            j2 = 0;
                        } else {
                            List<e> list4 = aVar.igE;
                            p.g(list4, "pcmDataList");
                            List<e> list5 = list4;
                            synchronized (list5) {
                                try {
                                    for (T t2 : list5) {
                                        if (p.j(t2.dtX, "background")) {
                                            j3 = t2.dua;
                                            Log.i(aVar.TAG, "get pts from background: ".concat(String.valueOf(j3)));
                                        }
                                    }
                                    x xVar2 = x.SXb;
                                } catch (Throwable th2) {
                                    AppMethodBeat.o(93716);
                                    throw th2;
                                }
                            }
                            j2 = j3;
                        }
                        Log.i(aVar.TAG, "mix finish pcm frame size: " + Q.length + ", pts:" + j2 + ", cost:" + Util.ticksToNow(currentTicks));
                        aVar.igS.invoke(Q, Long.valueOf(j2));
                    }
                }
                x xVar3 = x.SXb;
            } finally {
                AppMethodBeat.o(93716);
            }
        }
    }
}
