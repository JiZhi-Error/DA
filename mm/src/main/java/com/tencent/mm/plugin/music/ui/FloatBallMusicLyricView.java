package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ay.f;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.plugin.music.model.o;
import com.tencent.mm.plugin.music.ui.view.MarqueeLyricView;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;

public class FloatBallMusicLyricView extends LinearLayout {
    public d.a AhI;
    private a AkC;
    private TextView Amt;
    private MarqueeLyricView Amu;
    private e Amv;
    private int Amw;
    public IListener lEl;

    public FloatBallMusicLyricView(Context context) {
        this(context, null);
    }

    public FloatBallMusicLyricView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatBallMusicLyricView(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, (byte) 0);
    }

    private FloatBallMusicLyricView(Context context, AttributeSet attributeSet, int i2, byte b2) {
        super(context, attributeSet, i2, 0);
        AppMethodBeat.i(219860);
        this.AkC = null;
        this.Amv = null;
        this.Amw = -1;
        this.AhI = new d.a() {
            /* class com.tencent.mm.plugin.music.ui.FloatBallMusicLyricView.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.music.f.a.d.a
            public final void fn(int i2, int i3) {
                AppMethodBeat.i(219855);
                if (i2 >= 0 && i3 > 0) {
                    MMHandlerThread.postToMainThread(new Runnable((long) i2) {
                        /* class com.tencent.mm.plugin.music.ui.FloatBallMusicLyricView.AnonymousClass2 */
                        final /* synthetic */ long Amy;

                        {
                            this.Amy = r2;
                        }

                        public final void run() {
                            AppMethodBeat.i(219856);
                            int a2 = FloatBallMusicLyricView.a(FloatBallMusicLyricView.this, this.Amy);
                            if (a2 >= 0 && a2 < FloatBallMusicLyricView.this.Amv.Akn.size()) {
                                FloatBallMusicLyricView.this.Amu.bM(a2, FloatBallMusicLyricView.this.Amv.SQ(a2).content);
                            }
                            AppMethodBeat.o(219856);
                        }
                    });
                }
                AppMethodBeat.o(219855);
            }
        };
        this.lEl = new IListener<mx>() {
            /* class com.tencent.mm.plugin.music.ui.FloatBallMusicLyricView.AnonymousClass3 */

            {
                AppMethodBeat.i(219858);
                this.__eventId = mx.class.getName().hashCode();
                AppMethodBeat.o(219858);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(mx mxVar) {
                AppMethodBeat.i(219859);
                final mx mxVar2 = mxVar;
                switch (mxVar2.dSE.action) {
                    case 6:
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.music.ui.FloatBallMusicLyricView.AnonymousClass3.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(219857);
                                FloatBallMusicLyricView.a(FloatBallMusicLyricView.this, mxVar2.dSE.dSF);
                                AppMethodBeat.o(219857);
                            }
                        });
                        break;
                }
                AppMethodBeat.o(219859);
                return false;
            }
        };
        aa.jQ(context).inflate(R.layout.als, (ViewGroup) this, true);
        this.Amt = (TextView) findViewById(R.id.fqo);
        this.Amu = (MarqueeLyricView) findViewById(R.id.fq8);
        onResume();
        AppMethodBeat.o(219860);
    }

    public final void onResume() {
        AppMethodBeat.i(219861);
        this.lEl.alive();
        k.euj().etW().b(this.AhI);
        AppMethodBeat.o(219861);
    }

    private static boolean evb() {
        AppMethodBeat.i(219862);
        if (BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_PURPLE) {
            AppMethodBeat.o(219862);
            return true;
        } else if (1 == ((b) g.af(b.class)).a(b.a.clicfg_music_float_ball_lyric_enable, 0)) {
            AppMethodBeat.o(219862);
            return true;
        } else {
            AppMethodBeat.o(219862);
            return false;
        }
    }

    private void setMusicTitle(String str) {
        AppMethodBeat.i(219863);
        if (this.Amt != null) {
            this.Amt.setText(str);
        }
        AppMethodBeat.o(219863);
    }

    public void setMusicWrapper(f fVar) {
        AppMethodBeat.i(219864);
        setMusicTitle(fVar.jeX);
        setMusicLyric(fVar.jfe);
        AppMethodBeat.o(219864);
    }

    private void setMusicLyric(String str) {
        AppMethodBeat.i(219865);
        Log.i("MicroMsg.FloatBallMusicLyricView", "alvinluo setMusicLyric: %s", str);
        if (this.Amu != null) {
            this.AkC = ((com.tencent.mm.plugin.music.e.e) com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.e.e.class)).etY();
            if (this.AkC == null) {
                this.Amu.setVisibility(8);
                AppMethodBeat.o(219865);
                return;
            } else if (Util.isNullOrNil(this.AkC.field_songHAlbumUrl)) {
                this.Amu.setVisibility(8);
                ((com.tencent.mm.plugin.music.e.e) com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.e.e.class)).a(this.AkC, false, false);
                AppMethodBeat.o(219865);
                return;
            } else {
                j(this.AkC);
            }
        }
        AppMethodBeat.o(219865);
    }

    private void j(a aVar) {
        AppMethodBeat.i(219866);
        if (!evb()) {
            this.Amu.setVisibility(8);
            AppMethodBeat.o(219866);
            return;
        }
        this.Amv = o.euD().i(aVar);
        if (evc()) {
            this.Amu.setVisibility(8);
            AppMethodBeat.o(219866);
            return;
        }
        this.Amw = -1;
        this.Amu.setLyricObj(this.Amv);
        this.Amu.setVisibility(0);
        AppMethodBeat.o(219866);
    }

    private boolean evc() {
        AppMethodBeat.i(219867);
        if (this.Amv == null || this.Amv.Akn.size() <= 2) {
            AppMethodBeat.o(219867);
            return true;
        }
        AppMethodBeat.o(219867);
        return false;
    }

    static /* synthetic */ int a(FloatBallMusicLyricView floatBallMusicLyricView, long j2) {
        AppMethodBeat.i(219868);
        if (floatBallMusicLyricView.evc()) {
            Log.i("MicroMsg.FloatBallMusicLyricView", "getLyricLine, hasNoLyric");
            AppMethodBeat.o(219868);
            return -2;
        } else if (-1 == floatBallMusicLyricView.Amw) {
            floatBallMusicLyricView.Amw = 0;
            String str = floatBallMusicLyricView.Amv.SQ(floatBallMusicLyricView.Amw).content;
            while (str.trim().length() == 0) {
                floatBallMusicLyricView.Amw++;
                str = floatBallMusicLyricView.Amv.SQ(floatBallMusicLyricView.Amw).content;
            }
            int i2 = floatBallMusicLyricView.Amw;
            AppMethodBeat.o(219868);
            return i2;
        } else {
            int i3 = 0;
            int i4 = -1;
            while (i3 < floatBallMusicLyricView.Amv.Akn.size() && floatBallMusicLyricView.Amv.SQ(i3).timestamp < j2) {
                if (!floatBallMusicLyricView.Amv.SQ(i3).Akt) {
                    i4 = i3;
                }
                i3++;
            }
            if (-1 == i4) {
                Log.e("MicroMsg.FloatBallMusicLyricView", "getLyricLine, can not found");
                AppMethodBeat.o(219868);
                return -1;
            } else if (i4 == floatBallMusicLyricView.Amw) {
                Log.v("MicroMsg.FloatBallMusicLyricView", "getLyricLine, same line. [%s]", Integer.valueOf(floatBallMusicLyricView.Amw));
                AppMethodBeat.o(219868);
                return -3;
            } else if (i4 >= floatBallMusicLyricView.Amv.Akn.size()) {
                Log.e("MicroMsg.FloatBallMusicLyricView", "getLyricLine, over range, tempHighLightIndex:%s, SentenceSize:%s", Integer.valueOf(i4), Integer.valueOf(floatBallMusicLyricView.Amv.Akn.size()));
                AppMethodBeat.o(219868);
                return -5;
            } else {
                floatBallMusicLyricView.Amw = i4;
                String str2 = floatBallMusicLyricView.Amv.SQ(i4).content;
                if (str2.trim().length() == 0) {
                    Log.v("MicroMsg.FloatBallMusicLyricView", "getLyricLine, content length is 0");
                    AppMethodBeat.o(219868);
                    return -6;
                }
                Log.d("MicroMsg.FloatBallMusicLyricView", "lyric:%s", str2);
                AppMethodBeat.o(219868);
                return i4;
            }
        }
    }

    static /* synthetic */ void a(FloatBallMusicLyricView floatBallMusicLyricView, String str) {
        AppMethodBeat.i(219869);
        a aHW = o.euD().aHW(str);
        if (Util.isNullOrNil(aHW.field_songHAlbumUrl)) {
            Log.e("MicroMsg.FloatBallMusicLyricView", "updateLyric, should not be empty");
            AppMethodBeat.o(219869);
            return;
        }
        floatBallMusicLyricView.j(aHW);
        AppMethodBeat.o(219869);
    }
}
