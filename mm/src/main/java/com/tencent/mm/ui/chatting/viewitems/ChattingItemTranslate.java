package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.qo;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.pluginsdk.ui.span.h;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;

public class ChattingItemTranslate extends RelativeLayout {
    private boolean DMe = false;
    private CharacterStyle KdC = new ForegroundColorSpan(-5066062);
    private int KdF = 3;
    private SpannableStringBuilder Kdz = new SpannableStringBuilder();
    private MMNeat7extView POV;
    private LinearLayout POW;
    private ProgressBar POX;
    private TextView POY;
    private int POZ = 0;
    private WeakReference<com.tencent.mm.ui.chatting.e.a> PPa = null;
    private NeatTextView.b PPb;
    private CharacterStyle PPc = new ForegroundColorSpan(getContext().getResources().getColor(R.color.BW_0_Alpha_0_3));
    private boolean PPd;
    private GestureDetector PPe = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
        /* class com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.AnonymousClass2 */

        public final boolean onContextClick(MotionEvent motionEvent) {
            AppMethodBeat.i(233935);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onContextClick = super.onContextClick(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(onContextClick, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(233935);
            return onContextClick;
        }

        public final void onLongPress(MotionEvent motionEvent) {
            AppMethodBeat.i(233934);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$2", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
            super.onLongPress(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$2", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
            AppMethodBeat.o(233934);
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            AppMethodBeat.i(233933);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onSingleTapUp = super.onSingleTapUp(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(onSingleTapUp, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(233933);
            return onSingleTapUp;
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            AppMethodBeat.i(233932);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            if (ChattingItemTranslate.this.PPb == null) {
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(233932);
                return false;
            }
            boolean gS = ChattingItemTranslate.this.PPb.gS(ChattingItemTranslate.this.POV);
            com.tencent.mm.hellhoundlib.a.a.a(gS, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(233932);
            return gS;
        }
    });
    private long PyG = 0;
    private MTimerHandler cve = null;

    public enum c {
        NoTransform,
        PreTransform,
        Transforming,
        Transformed;

        public static c valueOf(String str) {
            AppMethodBeat.i(37426);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(37426);
            return cVar;
        }

        static {
            AppMethodBeat.i(37427);
            AppMethodBeat.o(37427);
        }
    }

    public enum b {
        Text,
        Voice;

        public static b valueOf(String str) {
            AppMethodBeat.i(233937);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(233937);
            return bVar;
        }

        static {
            AppMethodBeat.i(233938);
            AppMethodBeat.o(233938);
        }
    }

    public static class a extends bq {
        public CharSequence PPi;
        public int qcr = 1;

        public a(ca caVar, boolean z, int i2) {
            super(caVar, z, i2, (String) null, (char) 0);
        }
    }

    public ChattingItemTranslate(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(37428);
        AppMethodBeat.o(37428);
    }

    public final void init() {
        AppMethodBeat.i(37429);
        this.POV = (MMNeat7extView) findViewById(R.id.az6);
        this.POX = (ProgressBar) findViewById(R.id.az7);
        this.POW = (LinearLayout) findViewById(R.id.az4);
        this.POY = (TextView) findViewById(R.id.az3);
        this.POV.setOnTouchListener(new h(this.POV, new o(this.POV.getContext())));
        AppMethodBeat.o(37429);
    }

    private void a(final CharSequence charSequence, final int i2, final long j2) {
        AppMethodBeat.i(233939);
        if (i2 <= this.POZ) {
            this.POZ = i2 - 2;
        }
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(this.POV.hashCode());
        objArr[1] = Long.valueOf(j2);
        objArr[2] = charSequence != null ? Util.secPrint(charSequence.toString()) : BuildConfig.COMMAND;
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = Integer.valueOf(this.POZ);
        Log.i("MicroMsg.ChattingItemTranslate", "doVoiceTextAnimation(%s) %s %s %s %s", objArr);
        this.cve = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
            /* class com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(233931);
                ChattingItemTranslate.this.Kdz.clear();
                int i2 = ChattingItemTranslate.this.POZ + 2;
                if (i2 > i2) {
                    i2 = i2;
                }
                Log.d("MicroMsg.ChattingItemTranslate", "(%s)currentContentLength:%s newCurrentContentLength:%s endNum:%s animating:%s", Integer.valueOf(ChattingItemTranslate.this.POV.hashCode()), Integer.valueOf(ChattingItemTranslate.this.POZ), Integer.valueOf(i2), Integer.valueOf(i2), Boolean.valueOf(ChattingItemTranslate.this.DMe));
                ChattingItemTranslate.this.POZ = i2;
                ChattingItemTranslate.this.POV.aw(ChattingItemTranslate.a(ChattingItemTranslate.this, ChattingItemTranslate.this.Kdz, charSequence, ChattingItemTranslate.this.POZ));
                if (i2 == ChattingItemTranslate.this.POZ) {
                    if (!ChattingItemTranslate.this.DMe) {
                        qo qoVar = new qo();
                        qoVar.dXb.msgId = j2;
                        EventCenter.instance.publish(qoVar);
                    }
                    AppMethodBeat.o(233931);
                    return false;
                }
                AppMethodBeat.o(233931);
                return true;
            }
        }, true);
        this.cve.startTimer(0, 200);
        AppMethodBeat.o(233939);
    }

    private void gUi() {
        AppMethodBeat.i(233940);
        if (this.cve != null) {
            this.cve.stopTimer();
        }
        AppMethodBeat.o(233940);
    }

    public final void a(CharSequence charSequence, c cVar) {
        AppMethodBeat.i(37430);
        a(charSequence, cVar, false, b.Text, 0, null);
        AppMethodBeat.o(37430);
    }

    public final void a(CharSequence charSequence, c cVar, boolean z, b bVar, long j2, com.tencent.mm.ui.chatting.e.a aVar) {
        AppMethodBeat.i(233941);
        if (!Util.isNullOrNil(charSequence)) {
            if (aVar != null) {
                this.PPa = new WeakReference<>(aVar);
            }
            this.POV.setMinWidth(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 80));
            this.POV.setMaxWidth(((int) (((float) c.kk(MMApplicationContext.getContext())) / com.tencent.mm.cc.a.gvi())) - com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 5));
            this.POV.setVisibility(0);
            this.POX.setVisibility(8);
            if (bVar == b.Voice) {
                Ck(false);
                Log.d("MicroMsg.ChattingItemTranslate", "setContent(%s) msgId:%s currentMsgId:%s content:%s status:%s canAnimation:%s currentContentLength:%s", Integer.valueOf(this.POV.hashCode()), Long.valueOf(j2), Long.valueOf(this.PyG), Util.secPrint(charSequence.toString()), cVar, Boolean.valueOf(z), Integer.valueOf(this.POZ));
                if (this.PyG != j2) {
                    this.POV.aw("");
                    this.POZ = 0;
                    gUi();
                    this.cve = null;
                    this.DMe = false;
                }
                this.PyG = j2;
                if (z) {
                    this.POV.aw("");
                    this.POZ = 0;
                    gUi();
                    this.cve = null;
                    this.DMe = true;
                }
                if (cVar == c.Transformed && z) {
                    gUi();
                    a(charSequence, charSequence.length(), j2);
                    this.DMe = false;
                } else if (cVar == c.Transforming || z) {
                    gUi();
                    if (charSequence.length() > 3) {
                        a(charSequence, charSequence.length() - 3, j2);
                    } else {
                        this.POV.aw(charSequence);
                    }
                } else if (cVar != c.Transformed || this.cve == null) {
                    this.POV.aw(charSequence);
                } else if (this.POZ == charSequence.length()) {
                    this.POV.aw(charSequence);
                } else if (this.DMe) {
                    gUi();
                    a(charSequence, charSequence.length(), j2);
                    this.DMe = false;
                }
            } else {
                if (cVar == c.Transforming) {
                    this.Kdz.clear();
                    this.POV.aw(a(this.Kdz, charSequence));
                } else {
                    this.POV.aw(charSequence);
                }
                if (cVar == c.Transformed) {
                    Ck(true);
                } else {
                    Ck(false);
                }
            }
        } else if (cVar != c.NoTransform) {
            this.POX.setVisibility(0);
            this.POV.setVisibility(8);
            Ck(false);
        }
        setVisibility(0);
        AppMethodBeat.o(233941);
    }

    public MMNeat7extView getContentView() {
        return this.POV;
    }

    public void setBrandWording(String str) {
        AppMethodBeat.i(37431);
        this.POY.setText(str);
        AppMethodBeat.o(37431);
    }

    public void setOnDoubleClickListener(NeatTextView.b bVar) {
        this.PPb = bVar;
    }

    private void Ck(boolean z) {
        AppMethodBeat.i(37432);
        Context context = MMApplicationContext.getContext();
        if (context == null) {
            AppMethodBeat.o(37432);
        } else if (z) {
            this.POV.setPadding(com.tencent.mm.cb.a.fromDPToPix(context, 10), com.tencent.mm.cb.a.fromDPToPix(context, 8), com.tencent.mm.cb.a.fromDPToPix(context, 10), com.tencent.mm.cb.a.fromDPToPix(context, 4));
            this.POW.setVisibility(0);
            AppMethodBeat.o(37432);
        } else {
            this.POV.setPadding(com.tencent.mm.cb.a.fromDPToPix(context, 10), com.tencent.mm.cb.a.fromDPToPix(context, 8), com.tencent.mm.cb.a.fromDPToPix(context, 10), com.tencent.mm.cb.a.fromDPToPix(context, 8));
            this.POW.setVisibility(8);
            AppMethodBeat.o(37432);
        }
    }

    private SpannableStringBuilder a(SpannableStringBuilder spannableStringBuilder, CharSequence charSequence) {
        int length;
        int i2;
        AppMethodBeat.i(37433);
        if (spannableStringBuilder == null || charSequence == null || charSequence.length() == 0) {
            AppMethodBeat.o(37433);
        } else {
            if (charSequence.length() < this.KdF) {
                length = charSequence.length();
                i2 = 0;
            } else {
                length = charSequence.length();
                i2 = length - this.KdF;
            }
            spannableStringBuilder.append(charSequence).setSpan(this.KdC, i2, length, 33);
            AppMethodBeat.o(37433);
        }
        return spannableStringBuilder;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        AppMethodBeat.i(37434);
        int action = motionEvent.getAction();
        if (action == 1 && this.PPd) {
            Log.d("MicroMsg.ChattingItemTranslate", "ignore Action Up Event this time");
            AppMethodBeat.o(37434);
        } else {
            if (action == 0) {
                this.PPd = false;
            }
            if (this.PPb == null || this.PPe == null) {
                z = false;
            } else {
                GestureDetector gestureDetector = this.PPe;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                z = com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/ui/chatting/viewitems/ChattingItemTranslate", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            }
            if (!z) {
                z = super.onTouchEvent(motionEvent);
            }
            AppMethodBeat.o(37434);
        }
        return z;
    }

    public void setVisibility(int i2) {
        AppMethodBeat.i(233942);
        super.setVisibility(i2);
        if (i2 == 8) {
            this.POX.setVisibility(8);
        }
        AppMethodBeat.o(233942);
    }

    static /* synthetic */ SpannableStringBuilder a(ChattingItemTranslate chattingItemTranslate, SpannableStringBuilder spannableStringBuilder, CharSequence charSequence, int i2) {
        int i3;
        AppMethodBeat.i(233943);
        if (spannableStringBuilder == null || charSequence == null || charSequence.length() == 0) {
            AppMethodBeat.o(233943);
        } else {
            int length = charSequence.length();
            if (charSequence.length() >= i2) {
                i3 = i2 + 3 > charSequence.length() ? charSequence.length() : i2 + 3;
            } else {
                i2 = length;
                i3 = length;
            }
            spannableStringBuilder.append(charSequence.subSequence(0, i3)).setSpan(chattingItemTranslate.PPc, i2, i3, 33);
            AppMethodBeat.o(233943);
        }
        return spannableStringBuilder;
    }
}
