package com.tencent.liteav.network;

import android.os.Bundle;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class d implements f {

    /* renamed from: a  reason: collision with root package name */
    private f f933a = null;

    /* renamed from: b  reason: collision with root package name */
    private b f934b = null;

    /* renamed from: c  reason: collision with root package name */
    private long f935c = 0;

    /* renamed from: d  reason: collision with root package name */
    private long f936d = 0;

    /* renamed from: e  reason: collision with root package name */
    private b f937e = null;

    /* renamed from: f  reason: collision with root package name */
    private a f938f;

    /* renamed from: g  reason: collision with root package name */
    private long f939g = 0;

    /* renamed from: h  reason: collision with root package name */
    private long f940h = 0;

    public interface a {
        void onSwitchFinish(TXIStreamDownloader tXIStreamDownloader, boolean z);
    }

    public void a(f fVar) {
        this.f933a = fVar;
    }

    public d(a aVar) {
        this.f938f = aVar;
    }

    public void a() {
        AppMethodBeat.i(15400);
        if (this.f934b != null) {
            this.f934b.b(0);
        }
        if (this.f937e != null) {
            this.f937e.b(0);
        }
        AppMethodBeat.o(15400);
    }

    public void a(TXIStreamDownloader tXIStreamDownloader, TXIStreamDownloader tXIStreamDownloader2, long j2, long j3, String str) {
        AppMethodBeat.i(15401);
        TXCLog.i("TXCMultiStreamDownloader", "[SwitchStream] old downloader:" + tXIStreamDownloader.hashCode() + " new downloader:" + tXIStreamDownloader2.hashCode());
        this.f935c = tXIStreamDownloader.getCurrentTS();
        this.f936d = tXIStreamDownloader.getLastIFrameTS();
        this.f934b = new b(tXIStreamDownloader, this);
        this.f934b.a(this);
        ((TXCFLVDownloader) tXIStreamDownloader).recvData(true);
        Vector<e> vector = new Vector<>();
        vector.add(new e(str, false));
        tXIStreamDownloader2.setOriginUrl(str);
        ((TXCFLVDownloader) tXIStreamDownloader2).recvData(true);
        tXIStreamDownloader2.startDownload(vector, false, false, tXIStreamDownloader.mEnableMessage, tXIStreamDownloader.mEnableMetaData);
        this.f937e = new b(tXIStreamDownloader2, this);
        this.f937e.a(this.f935c);
        AppMethodBeat.o(15401);
    }

    public void b() {
        AppMethodBeat.i(15402);
        this.f934b.a((f) null);
        this.f937e.a(this);
        this.f934b = this.f937e;
        this.f937e = null;
        TXCLog.w("TXCMultiStreamDownloader", "[SwitchStream] end at " + this.f935c + " stop ts " + this.f940h + " start ts " + this.f939g + " diff ts " + (this.f940h > this.f939g ? this.f940h - this.f939g : this.f939g - this.f940h));
        AppMethodBeat.o(15402);
    }

    /* access modifiers changed from: package-private */
    public void a(TXIStreamDownloader tXIStreamDownloader, boolean z) {
        AppMethodBeat.i(15403);
        TXCLog.i("TXCMultiStreamDownloader", "[SwitchStream] switch stream finish. result:".concat(String.valueOf(z)));
        if (this.f938f != null) {
            this.f938f.onSwitchFinish(tXIStreamDownloader, z);
        }
        AppMethodBeat.o(15403);
    }

    /* access modifiers changed from: package-private */
    public long c() {
        AppMethodBeat.i(259875);
        if (this.f934b != null) {
            this.f934b.b(this.f935c);
        }
        TXCLog.i("TXCMultiStreamDownloader", "[SwitchStream] stop original downloader, when video ts is" + this.f935c);
        long j2 = this.f935c;
        AppMethodBeat.o(259875);
        return j2;
    }

    /* access modifiers changed from: package-private */
    public void a(long j2) {
        this.f939g = j2;
    }

    /* access modifiers changed from: package-private */
    public void b(long j2) {
        this.f940h = j2;
    }

    @Override // com.tencent.liteav.network.f
    public void onPullAudio(com.tencent.liteav.basic.structs.a aVar) {
        AppMethodBeat.i(15405);
        if (this.f933a != null) {
            this.f933a.onPullAudio(aVar);
        }
        AppMethodBeat.o(15405);
    }

    @Override // com.tencent.liteav.network.f
    public void onPullNAL(TXSNALPacket tXSNALPacket) {
        AppMethodBeat.i(15406);
        this.f935c = tXSNALPacket.pts;
        if (tXSNALPacket.nalType == 0) {
            this.f936d = tXSNALPacket.pts;
        }
        if (this.f933a != null) {
            this.f933a.onPullNAL(tXSNALPacket);
        }
        AppMethodBeat.o(15406);
    }

    /* access modifiers changed from: package-private */
    public static class b implements com.tencent.liteav.basic.b.b, f {

        /* renamed from: a  reason: collision with root package name */
        private final int f941a = 2;

        /* renamed from: b  reason: collision with root package name */
        private long f942b = 0;

        /* renamed from: c  reason: collision with root package name */
        private long f943c = 0;

        /* renamed from: d  reason: collision with root package name */
        private int f944d = 0;

        /* renamed from: e  reason: collision with root package name */
        private boolean f945e = false;

        /* renamed from: f  reason: collision with root package name */
        private long f946f = 0;

        /* renamed from: g  reason: collision with root package name */
        private long f947g = 0;

        /* renamed from: h  reason: collision with root package name */
        private long f948h = 0;

        /* renamed from: i  reason: collision with root package name */
        private ArrayList<TXSNALPacket> f949i = new ArrayList<>();

        /* renamed from: j  reason: collision with root package name */
        private ArrayList<com.tencent.liteav.basic.structs.a> f950j = new ArrayList<>();
        private TXIStreamDownloader k = null;
        private WeakReference<d> l;
        private f m;

        public b(TXIStreamDownloader tXIStreamDownloader, d dVar) {
            AppMethodBeat.i(15490);
            this.l = new WeakReference<>(dVar);
            this.k = tXIStreamDownloader;
            this.k.setListener(this);
            AppMethodBeat.o(15490);
        }

        public void a(long j2) {
            AppMethodBeat.i(15491);
            TXCLog.i("TXCMultiStreamDownloader", "[SwitchStream] start switch. current video pts:".concat(String.valueOf(j2)));
            this.f944d = 0;
            this.f942b = j2;
            this.k.setListener(this);
            this.k.setNotifyListener(this);
            AppMethodBeat.o(15491);
        }

        public void b(long j2) {
            AppMethodBeat.i(15492);
            TXCLog.i("TXCMultiStreamDownloader", "[SwitchStream] stop switch. pts:".concat(String.valueOf(j2)));
            this.f942b = 0;
            this.f946f = j2;
            this.f948h = 0;
            this.f947g = 0;
            if (this.k != null && this.f946f == 0) {
                this.k.stopDownload();
                this.k = null;
            }
            AppMethodBeat.o(15492);
        }

        public void a(f fVar) {
            this.m = fVar;
        }

        @Override // com.tencent.liteav.network.f
        public void onPullAudio(com.tencent.liteav.basic.structs.a aVar) {
            AppMethodBeat.i(15493);
            if (this.f942b > 0) {
                a(aVar);
                AppMethodBeat.o(15493);
            } else if (this.f946f > 0) {
                b(aVar);
                AppMethodBeat.o(15493);
            } else {
                if (this.m != null) {
                    this.m.onPullAudio(aVar);
                }
                AppMethodBeat.o(15493);
            }
        }

        @Override // com.tencent.liteav.network.f
        public void onPullNAL(TXSNALPacket tXSNALPacket) {
            AppMethodBeat.i(15494);
            if (tXSNALPacket == null) {
                AppMethodBeat.o(15494);
            } else if (this.f942b > 0) {
                a(tXSNALPacket);
                AppMethodBeat.o(15494);
            } else if (this.f946f > 0) {
                b(tXSNALPacket);
                AppMethodBeat.o(15494);
            } else {
                if (this.m != null) {
                    this.m.onPullNAL(tXSNALPacket);
                }
                AppMethodBeat.o(15494);
            }
        }

        private void a(com.tencent.liteav.basic.structs.a aVar) {
            AppMethodBeat.i(15495);
            if (aVar == null) {
                AppMethodBeat.o(15495);
            } else if (aVar.f424e < this.f943c || aVar.f424e < this.f942b) {
                AppMethodBeat.o(15495);
            } else if (this.m == null || this.f943c <= 0 || aVar.f424e < this.f943c) {
                this.f950j.add(aVar);
                AppMethodBeat.o(15495);
            } else {
                this.m.onPullAudio(aVar);
                AppMethodBeat.o(15495);
            }
        }

        private void b(com.tencent.liteav.basic.structs.a aVar) {
            AppMethodBeat.i(15496);
            if (this.f948h > 0) {
                AppMethodBeat.o(15496);
            } else if (this.f947g <= 0 || aVar == null || aVar.f424e < this.f947g) {
                if (this.m != null) {
                    this.m.onPullAudio(aVar);
                }
                AppMethodBeat.o(15496);
            } else {
                this.f948h = aVar.f424e;
                AppMethodBeat.o(15496);
            }
        }

        private void a(TXSNALPacket tXSNALPacket) {
            AppMethodBeat.i(15497);
            d dVar = this.l.get();
            if (tXSNALPacket.nalType == 0 && !this.f945e) {
                this.f944d++;
                TXCLog.i("TXCMultiStreamDownloader", "[SwitchStream] processing... current video ts:" + tXSNALPacket.pts + " target video ts:" + tXSNALPacket.pts + " check times:" + this.f944d + " maxTimes:2");
                if (dVar != null && (dVar.f936d <= tXSNALPacket.pts || this.f944d == 2)) {
                    if (dVar.f936d <= tXSNALPacket.pts) {
                        TXCLog.i("TXCMultiStreamDownloader", "[SwitchStream] switch video success, video data is ready.");
                    } else if (this.f944d == 2) {
                        TXCLog.e("TXCMultiStreamDownloader", "[SwitchStream] switch video failed. all times retried. max times:2");
                    }
                    this.f942b = dVar.c();
                    this.f945e = true;
                }
            }
            if (!this.f945e) {
                AppMethodBeat.o(15497);
                return;
            }
            if (dVar != null) {
                dVar.a(tXSNALPacket.pts);
            }
            if (tXSNALPacket.pts >= this.f942b) {
                if (tXSNALPacket.nalType == 0 && this.f943c == 0) {
                    this.f943c = tXSNALPacket.pts;
                    TXCLog.w("TXCMultiStreamDownloader", "[SwitchStream] pre start end " + tXSNALPacket.pts + " from " + this.f942b + " type " + tXSNALPacket.nalType);
                }
                if (this.f943c > 0) {
                    if (this.m != null) {
                        if (dVar != null) {
                            dVar.a(this.k, true);
                        }
                        if (!this.f950j.isEmpty()) {
                            Iterator<com.tencent.liteav.basic.structs.a> it = this.f950j.iterator();
                            while (it.hasNext()) {
                                com.tencent.liteav.basic.structs.a next = it.next();
                                if (next.f424e >= this.f943c) {
                                    TXCLog.i("TXCMultiStreamDownloader", "[SwitchStream] pre start cache audio pts " + next.f424e + " from " + this.f943c);
                                    this.m.onPullAudio(next);
                                }
                            }
                            TXCLog.w("TXCMultiStreamDownloader", "[SwitchStream] pre start end audio cache  " + this.f950j.size());
                            this.f950j.clear();
                        }
                        if (!this.f949i.isEmpty()) {
                            TXCLog.w("TXCMultiStreamDownloader", "[SwitchStream] pre start end video cache  " + this.f949i.size());
                            Iterator<TXSNALPacket> it2 = this.f949i.iterator();
                            while (it2.hasNext()) {
                                this.m.onPullNAL(it2.next());
                            }
                            this.f949i.clear();
                        }
                        TXCLog.w("TXCMultiStreamDownloader", "[SwitchStream] pre start first pull nal " + tXSNALPacket.pts + " from " + this.f943c + " type " + tXSNALPacket.nalType);
                        this.m.onPullNAL(tXSNALPacket);
                        this.m = null;
                        AppMethodBeat.o(15497);
                        return;
                    }
                    TXCLog.i("TXCMultiStreamDownloader", "[SwitchStream] pre start cache video pts " + tXSNALPacket.pts + " from " + this.f943c + " type " + tXSNALPacket.nalType);
                    this.f949i.add(tXSNALPacket);
                }
            }
            AppMethodBeat.o(15497);
        }

        private void b(TXSNALPacket tXSNALPacket) {
            AppMethodBeat.i(15498);
            d dVar = this.l.get();
            if (dVar != null) {
                dVar.b(tXSNALPacket.pts);
            }
            if (tXSNALPacket.pts >= this.f946f) {
                if (tXSNALPacket.nalType == 0) {
                    this.f947g = tXSNALPacket.pts;
                }
                if (this.f947g > 0) {
                    if (this.f948h > 0) {
                        TXCLog.i("TXCMultiStreamDownloader", "[SwitchStream] switch finish and stop old downloader. video ts:" + this.f947g + " audio ts:" + this.f948h + " stop ts:" + this.f946f);
                        if (dVar != null) {
                            dVar.b();
                        }
                        this.m = null;
                        this.k.setListener(null);
                        this.k.stopDownload();
                        AppMethodBeat.o(15498);
                        return;
                    }
                    TXCLog.w("TXCMultiStreamDownloader", "[SwitchStream] delay stop video end wait audio end video pts " + tXSNALPacket.pts + " from " + this.f946f + " type " + tXSNALPacket.nalType);
                    AppMethodBeat.o(15498);
                    return;
                } else if (this.m != null) {
                    this.m.onPullNAL(tXSNALPacket);
                    AppMethodBeat.o(15498);
                    return;
                }
            } else if (this.m != null) {
                this.m.onPullNAL(tXSNALPacket);
            }
            AppMethodBeat.o(15498);
        }

        @Override // com.tencent.liteav.basic.b.b
        public void onNotifyEvent(int i2, Bundle bundle) {
            AppMethodBeat.i(15499);
            if (i2 == -2301 || i2 == 3010) {
                d dVar = this.l.get();
                if (dVar != null) {
                    dVar.a(this.k, false);
                }
                this.k.setNotifyListener(null);
            }
            AppMethodBeat.o(15499);
        }
    }
}
