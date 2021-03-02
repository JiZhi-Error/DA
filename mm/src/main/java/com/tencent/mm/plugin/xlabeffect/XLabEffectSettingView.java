package com.tencent.mm.plugin.xlabeffect;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.media.widget.camerarecordview.preview.e;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJK\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2!\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00140\u001aH\u0002R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/xlabeffect/XLabEffectSettingView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "cameraView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "getCameraView", "()Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "setCameraView", "(Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;)V", "setSeekBarItem", "", "seekBarId", "textViewId", "strId", "value", "onChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "progress", "plugin-xlabeffect_release"})
public final class XLabEffectSettingView extends FrameLayout {
    private final String TAG;
    private e wgS;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public XLabEffectSettingView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(184237);
        this.TAG = "MicroMsg.XLabEffectSettingView";
        View.inflate(context, R.layout.a1o, this);
        c cVar = c.JRA;
        a(R.id.jsa, R.id.jsb, R.string.j76, c.aEl(), new b<Integer, x>(this) {
            /* class com.tencent.mm.plugin.xlabeffect.XLabEffectSettingView.AnonymousClass1 */
            final /* synthetic */ XLabEffectSettingView JRB;

            {
                this.JRB = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Integer num) {
                AppMethodBeat.i(184224);
                final int intValue = num.intValue();
                e cameraView = this.JRB.getCameraView();
                if (cameraView != null) {
                    cameraView.j(new kotlin.g.a.a<x>() {
                        /* class com.tencent.mm.plugin.xlabeffect.XLabEffectSettingView.AnonymousClass1.AnonymousClass1 */

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ x invoke() {
                            AppMethodBeat.i(184223);
                            c cVar = c.JRA;
                            c.ky(0, intValue);
                            x xVar = x.SXb;
                            AppMethodBeat.o(184223);
                            return xVar;
                        }
                    });
                }
                x xVar = x.SXb;
                AppMethodBeat.o(184224);
                return xVar;
            }
        });
        c cVar2 = c.JRA;
        a(R.id.js5, R.id.js6, R.string.j73, c.aEm(), new b<Integer, x>(this) {
            /* class com.tencent.mm.plugin.xlabeffect.XLabEffectSettingView.AnonymousClass2 */
            final /* synthetic */ XLabEffectSettingView JRB;

            {
                this.JRB = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Integer num) {
                AppMethodBeat.i(184226);
                final int intValue = num.intValue();
                e cameraView = this.JRB.getCameraView();
                if (cameraView != null) {
                    cameraView.j(new kotlin.g.a.a<x>() {
                        /* class com.tencent.mm.plugin.xlabeffect.XLabEffectSettingView.AnonymousClass2.AnonymousClass1 */

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ x invoke() {
                            AppMethodBeat.i(184225);
                            c cVar = c.JRA;
                            c.ky(1, intValue);
                            x xVar = x.SXb;
                            AppMethodBeat.o(184225);
                            return xVar;
                        }
                    });
                }
                x xVar = x.SXb;
                AppMethodBeat.o(184226);
                return xVar;
            }
        });
        c cVar3 = c.JRA;
        a(R.id.js7, R.id.js8, R.string.j74, c.aEn(), new b<Integer, x>(this) {
            /* class com.tencent.mm.plugin.xlabeffect.XLabEffectSettingView.AnonymousClass3 */
            final /* synthetic */ XLabEffectSettingView JRB;

            {
                this.JRB = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Integer num) {
                AppMethodBeat.i(184228);
                final int intValue = num.intValue();
                e cameraView = this.JRB.getCameraView();
                if (cameraView != null) {
                    cameraView.j(new kotlin.g.a.a<x>() {
                        /* class com.tencent.mm.plugin.xlabeffect.XLabEffectSettingView.AnonymousClass3.AnonymousClass1 */

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ x invoke() {
                            AppMethodBeat.i(184227);
                            c cVar = c.JRA;
                            c.ky(2, intValue);
                            x xVar = x.SXb;
                            AppMethodBeat.o(184227);
                            return xVar;
                        }
                    });
                }
                x xVar = x.SXb;
                AppMethodBeat.o(184228);
                return xVar;
            }
        });
        c cVar4 = c.JRA;
        a(R.id.js9, R.id.js_, R.string.j75, c.aEo(), new b<Integer, x>(this) {
            /* class com.tencent.mm.plugin.xlabeffect.XLabEffectSettingView.AnonymousClass4 */
            final /* synthetic */ XLabEffectSettingView JRB;

            {
                this.JRB = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Integer num) {
                AppMethodBeat.i(184230);
                final int intValue = num.intValue();
                e cameraView = this.JRB.getCameraView();
                if (cameraView != null) {
                    cameraView.j(new kotlin.g.a.a<x>() {
                        /* class com.tencent.mm.plugin.xlabeffect.XLabEffectSettingView.AnonymousClass4.AnonymousClass1 */

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ x invoke() {
                            AppMethodBeat.i(184229);
                            c cVar = c.JRA;
                            c.ky(3, intValue);
                            x xVar = x.SXb;
                            AppMethodBeat.o(184229);
                            return xVar;
                        }
                    });
                }
                x xVar = x.SXb;
                AppMethodBeat.o(184230);
                return xVar;
            }
        });
        c cVar5 = c.JRA;
        a(R.id.js3, R.id.js4, R.string.j72, c.aEp(), new b<Integer, x>(this) {
            /* class com.tencent.mm.plugin.xlabeffect.XLabEffectSettingView.AnonymousClass5 */
            final /* synthetic */ XLabEffectSettingView JRB;

            {
                this.JRB = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Integer num) {
                AppMethodBeat.i(184232);
                final int intValue = num.intValue();
                e cameraView = this.JRB.getCameraView();
                if (cameraView != null) {
                    cameraView.j(new kotlin.g.a.a<x>() {
                        /* class com.tencent.mm.plugin.xlabeffect.XLabEffectSettingView.AnonymousClass5.AnonymousClass1 */

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ x invoke() {
                            AppMethodBeat.i(184231);
                            c cVar = c.JRA;
                            c.ky(4, intValue);
                            x xVar = x.SXb;
                            AppMethodBeat.o(184231);
                            return xVar;
                        }
                    });
                }
                x xVar = x.SXb;
                AppMethodBeat.o(184232);
                return xVar;
            }
        });
        setBackgroundColor(-1);
        AppMethodBeat.o(184237);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public XLabEffectSettingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(184238);
        AppMethodBeat.o(184238);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public XLabEffectSettingView(Context context) {
        this(context, null);
        p.h(context, "context");
        AppMethodBeat.i(184239);
        AppMethodBeat.o(184239);
    }

    public final e getCameraView() {
        return this.wgS;
    }

    public final void setCameraView(e eVar) {
        this.wgS = eVar;
    }

    private final void a(int i2, int i3, int i4, int i5, b<? super Integer, x> bVar) {
        AppMethodBeat.i(184236);
        View findViewById = findViewById(i2);
        p.g(findViewById, "findViewById(seekBarId)");
        SeekBar seekBar = (SeekBar) findViewById;
        View findViewById2 = findViewById(i3);
        p.g(findViewById2, "findViewById(textViewId)");
        TextView textView = (TextView) findViewById2;
        textView.setText(getResources().getString(i4, Integer.valueOf(i5)));
        seekBar.setProgress(i5);
        seekBar.setOnSeekBarChangeListener(new a(this, textView, i4, bVar));
        AppMethodBeat.o(184236);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/xlabeffect/XLabEffectSettingView$setSeekBarItem$1", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "onProgressChanged", "", "seekBar", "Landroid/widget/SeekBar;", "progress", "", "fromUser", "", "onStartTrackingTouch", "onStopTrackingTouch", "plugin-xlabeffect_release"})
    public static final class a implements SeekBar.OnSeekBarChangeListener {
        final /* synthetic */ int BXj;
        final /* synthetic */ b BXk;
        final /* synthetic */ XLabEffectSettingView JRB;
        final /* synthetic */ TextView hUM;

        a(XLabEffectSettingView xLabEffectSettingView, TextView textView, int i2, b bVar) {
            this.JRB = xLabEffectSettingView;
            this.hUM = textView;
            this.BXj = i2;
            this.BXk = bVar;
        }

        public final void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            AppMethodBeat.i(184233);
            p.h(seekBar, "seekBar");
            this.hUM.setText(this.JRB.getResources().getString(this.BXj, Integer.valueOf(i2)));
            this.BXk.invoke(Integer.valueOf(i2));
            AppMethodBeat.o(184233);
        }

        public final void onStartTrackingTouch(SeekBar seekBar) {
            AppMethodBeat.i(184234);
            p.h(seekBar, "seekBar");
            AppMethodBeat.o(184234);
        }

        public final void onStopTrackingTouch(SeekBar seekBar) {
            AppMethodBeat.i(184235);
            p.h(seekBar, "seekBar");
            AppMethodBeat.o(184235);
        }
    }
}
