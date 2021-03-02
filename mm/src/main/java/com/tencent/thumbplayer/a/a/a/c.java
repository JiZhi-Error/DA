package com.tencent.thumbplayer.a.a.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.a.a.a;
import com.tencent.thumbplayer.core.common.TPMediaTrackInfo;
import com.tencent.thumbplayer.core.subtitle.ITPSubtitleParserCallback;
import com.tencent.thumbplayer.core.subtitle.TPSubtitleParser;
import com.tencent.thumbplayer.utils.g;
import com.tencent.thumbplayer.utils.j;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class c implements a {
    private a RWA = a.IDLE;
    a.AbstractC2198a RWu;
    a.b RWv;
    TPSubtitleParser RWw;
    String RWx;
    private Future<?> RWy = null;
    private final Object RWz = new Object();

    enum a {
        IDLE,
        INITED,
        PREPARED,
        STOPED,
        ERROR;

        public static a valueOf(String str) {
            AppMethodBeat.i(188771);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(188771);
            return aVar;
        }

        static {
            AppMethodBeat.i(188772);
            AppMethodBeat.o(188772);
        }
    }

    public c() {
        AppMethodBeat.i(188773);
        AppMethodBeat.o(188773);
    }

    @Override // com.tencent.thumbplayer.a.a.a.a
    public final void a(a.AbstractC2198a aVar) {
        this.RWu = aVar;
    }

    @Override // com.tencent.thumbplayer.a.a.a.a
    public final void a(a.b bVar) {
        this.RWv = bVar;
    }

    @Override // com.tencent.thumbplayer.a.a.a.a
    public final void setDataSource(String str) {
        AppMethodBeat.i(188774);
        if (this.RWA != a.IDLE) {
            g.e("TPSysPlayerExternalSubtitle", "setDataSource, illegalState, state:" + this.RWA);
            AppMethodBeat.o(188774);
        } else if (TextUtils.isEmpty(str)) {
            g.e("TPSysPlayerExternalSubtitle", "setDataSource, illegal argument, url:".concat(String.valueOf(str)));
            AppMethodBeat.o(188774);
        } else {
            g.i("TPSysPlayerExternalSubtitle", "setDataSource, url: ".concat(String.valueOf(str)));
            if (this.RWw != null) {
                g.w("TPSysPlayerExternalSubtitle", "setDataSource, mTpSubParser != null.");
                try {
                    this.RWw.unInit();
                } catch (Exception e2) {
                }
                this.RWw = null;
            }
            this.RWw = new TPSubtitleParser(str, new ITPSubtitleParserCallback() {
                /* class com.tencent.thumbplayer.a.a.a.c.AnonymousClass1 */

                @Override // com.tencent.thumbplayer.core.subtitle.ITPSubtitleParserCallback
                public final void onLoadResult(int i2) {
                    AppMethodBeat.i(188767);
                    g.i("TPSysPlayerExternalSubtitle", "onLoadResult, index:".concat(String.valueOf(i2)));
                    AppMethodBeat.o(188767);
                }

                @Override // com.tencent.thumbplayer.core.subtitle.ITPSubtitleParserCallback
                public final void onSelectResult(int i2, long j2) {
                    AppMethodBeat.i(188768);
                    g.i("TPSysPlayerExternalSubtitle", "onSelectResult, index:" + i2 + ", long:" + j2);
                    AppMethodBeat.o(188768);
                }
            });
            this.RWA = a.INITED;
            AppMethodBeat.o(188774);
        }
    }

    @Override // com.tencent.thumbplayer.a.a.a.a
    public final void prepare() {
        AppMethodBeat.i(188775);
        if (this.RWA != a.INITED) {
            g.e("TPSysPlayerExternalSubtitle", "prepare, illegalState, state:" + this.RWA);
            AppMethodBeat.o(188775);
            return;
        }
        g.i("TPSysPlayerExternalSubtitle", "prepare.");
        this.RWw.init();
        TPMediaTrackInfo[] trackInfo = this.RWw.getTrackInfo();
        if (trackInfo == null || trackInfo.length <= 0) {
            g.w("TPSysPlayerExternalSubtitle", "prepare, err, trackInfos is empty.");
            this.RWA = a.ERROR;
            AppMethodBeat.o(188775);
        } else if (trackInfo[0].trackType != 3) {
            this.RWA = a.ERROR;
            g.w("TPSysPlayerExternalSubtitle", "prepare, err, track type not match.");
            AppMethodBeat.o(188775);
        } else {
            this.RWw.selectTrackAsync(0, System.currentTimeMillis());
            this.RWA = a.PREPARED;
            synchronized (this.RWz) {
                try {
                    if (this.RWy != null) {
                        this.RWy.cancel(true);
                        this.RWy = null;
                    }
                    this.RWy = j.getScheduledExecutorServiceInstance().scheduleAtFixedRate(new Runnable() {
                        /* class com.tencent.thumbplayer.a.a.a.c.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(188769);
                            c cVar = c.this;
                            a.b bVar = cVar.RWv;
                            a.AbstractC2198a aVar = cVar.RWu;
                            if (bVar == null || aVar == null) {
                                g.w("TPSysPlayerExternalSubtitle", "subPollFunc, posLis:" + bVar + ", subLis:" + aVar);
                                AppMethodBeat.o(188769);
                                return;
                            }
                            long currentPosition = bVar.getCurrentPosition();
                            if (currentPosition < 0) {
                                g.w("TPSysPlayerExternalSubtitle", "subPollFunc, cur position:".concat(String.valueOf(currentPosition)));
                                AppMethodBeat.o(188769);
                                return;
                            }
                            String subtitleText = cVar.RWw.getSubtitleText(currentPosition, 0);
                            if (!TextUtils.equals(cVar.RWx, subtitleText)) {
                                cVar.RWx = subtitleText;
                                aVar.a(new a.c(subtitleText));
                            }
                            AppMethodBeat.o(188769);
                        }
                    }, 0, 200, TimeUnit.MILLISECONDS);
                } finally {
                    AppMethodBeat.o(188775);
                }
            }
        }
    }

    @Override // com.tencent.thumbplayer.a.a.a.a
    public final void stop() {
        AppMethodBeat.i(188776);
        g.i("TPSysPlayerExternalSubtitle", "stop.");
        if (this.RWA == a.INITED || this.RWA == a.PREPARED || this.RWA == a.ERROR) {
            if (this.RWw != null) {
                try {
                    this.RWw.unInit();
                } catch (Exception e2) {
                    g.e("TPSysPlayerExternalSubtitle", e2);
                }
            }
            this.RWw = null;
        }
        synchronized (this.RWz) {
            try {
                if (this.RWy != null) {
                    this.RWy.cancel(true);
                    this.RWy = null;
                }
            } catch (Throwable th) {
                AppMethodBeat.o(188776);
                throw th;
            }
        }
        this.RWA = a.STOPED;
        AppMethodBeat.o(188776);
    }

    @Override // com.tencent.thumbplayer.a.a.a.a
    public final void reset() {
        AppMethodBeat.i(188777);
        if (this.RWA != a.IDLE) {
            if (this.RWw != null) {
                try {
                    this.RWw.unInit();
                } catch (Exception e2) {
                    g.e("TPSysPlayerExternalSubtitle", e2);
                }
            }
            this.RWw = null;
        }
        synchronized (this.RWz) {
            try {
                if (this.RWy != null) {
                    this.RWy.cancel(true);
                    this.RWy = null;
                }
            } catch (Throwable th) {
                AppMethodBeat.o(188777);
                throw th;
            }
        }
        this.RWA = a.IDLE;
        AppMethodBeat.o(188777);
    }

    @Override // com.tencent.thumbplayer.a.a.a.a
    public final void release() {
        AppMethodBeat.i(188778);
        g.i("TPSysPlayerExternalSubtitle", "release.");
        this.RWv = null;
        this.RWu = null;
        AppMethodBeat.o(188778);
    }
}
