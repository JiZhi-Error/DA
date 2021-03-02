package com.tencent.mm.plugin.finder.video.plugin;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001(B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0011J\b\u0010\u001f\u001a\u00020\u001aH\u0016J\b\u0010 \u001a\u00020\u001aH\u0016J\u0010\u0010!\u001a\u00020\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u001aH\u0002J\u000e\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u001cR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/plugin/RecordAudioPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Lcom/tencent/mm/plugin/finder/video/plugin/AudioPanelPlugin$AudioStateListener;", "layout", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "addMusicDuration", "Landroid/widget/TextView;", "addMusicGroup", "Landroid/view/View;", "addMusicIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "addMusicIndicator", "addMusicText", "canAddMusic", "", "hasMusic", "getLayout", "()Landroid/view/ViewGroup;", "musicInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "changeRecordDuration", "", "durationMs", "", "enableAddMusic", "enabled", "onAudioPause", "onAudioResume", "setMusic", "setVisibility", "visibility", "", "updateContent", "updateProgress", "timeMs", "Companion", "plugin-finder_release"})
public final class g implements t {
    private static final long whm = 60000;
    public static final a whn = new a((byte) 0);
    final ViewGroup wgq;
    final d wgr;
    private final View whe;
    private final WeImageView whf;
    private final TextView whg;
    private final View whh;
    private final TextView whi;
    public AudioCacheInfo whj;
    public boolean whk;
    private boolean whl = true;

    public g(ViewGroup viewGroup, d dVar) {
        p.h(viewGroup, "layout");
        p.h(dVar, "status");
        AppMethodBeat.i(254500);
        this.wgq = viewGroup;
        this.wgr = dVar;
        View findViewById = this.wgq.findViewById(R.id.gwa);
        p.g(findViewById, "layout.findViewById(R.id.record_add_music)");
        this.whe = findViewById;
        View findViewById2 = this.wgq.findViewById(R.id.gwc);
        p.g(findViewById2, "layout.findViewById(R.id.record_add_music_icon)");
        this.whf = (WeImageView) findViewById2;
        View findViewById3 = this.wgq.findViewById(R.id.gwe);
        p.g(findViewById3, "layout.findViewById(R.id.record_add_music_text)");
        this.whg = (TextView) findViewById3;
        View findViewById4 = this.wgq.findViewById(R.id.gwd);
        p.g(findViewById4, "layout.findViewById(R.id…cord_add_music_indicator)");
        this.whh = findViewById4;
        View findViewById5 = this.wgq.findViewById(R.id.gwb);
        p.g(findViewById5, "layout.findViewById(R.id…ecord_add_music_duration)");
        this.whi = (TextView) findViewById5;
        this.whe.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.video.plugin.g.AnonymousClass1 */
            final /* synthetic */ g who;

            {
                this.who = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(254495);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/plugin/RecordAudioPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (this.who.whl) {
                    d.b.a(this.who.wgr, d.c.BWV);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/plugin/RecordAudioPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(254495);
            }
        });
        this.whg.setSelected(true);
        this.whe.post(new Runnable(this) {
            /* class com.tencent.mm.plugin.finder.video.plugin.g.AnonymousClass2 */
            final /* synthetic */ g who;

            {
                this.who = r1;
            }

            public final void run() {
                AppMethodBeat.i(254496);
                this.who.whg.setMaxWidth(((this.who.whe.getWidth() - this.who.whf.getWidth()) - this.who.whh.getWidth()) - com.tencent.mm.cb.a.fromDPToPix(this.who.wgq.getContext(), 54));
                AppMethodBeat.o(254496);
            }
        });
        if (this.whl) {
            this.whl = false;
            this.whh.setVisibility(4);
        }
        AppMethodBeat.o(254500);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void aSs() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final String name() {
        return null;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        return false;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onDetach() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onPause() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(254502);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(254502);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/plugin/RecordAudioPlugin$Companion;", "", "()V", "DURATION_HINT_THRESHOLD", "", "getDURATION_HINT_THRESHOLD", "()J", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(254501);
        AppMethodBeat.o(254501);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
        AppMethodBeat.i(254497);
        this.whe.setVisibility(i2);
        if (i2 == 0) {
            dFW();
        }
        AppMethodBeat.o(254497);
    }

    public final void dFW() {
        ArrayList<String> arrayList;
        ArrayList<String> arrayList2;
        String sb;
        String str;
        String str2 = null;
        AppMethodBeat.i(254498);
        if (this.whj == null) {
            this.whg.setText(R.string.d80);
            Gt(whm);
            AppMethodBeat.o(254498);
            return;
        }
        TextView textView = this.whg;
        AudioCacheInfo audioCacheInfo = this.whj;
        if (audioCacheInfo != null) {
            arrayList = audioCacheInfo.BOZ;
        } else {
            arrayList = null;
        }
        ArrayList<String> arrayList3 = arrayList;
        if (arrayList3 == null || arrayList3.isEmpty()) {
            AudioCacheInfo audioCacheInfo2 = this.whj;
            if (audioCacheInfo2 != null) {
                str = audioCacheInfo2.BPc;
            } else {
                str = null;
            }
            sb = str;
        } else {
            AudioCacheInfo audioCacheInfo3 = this.whj;
            if (audioCacheInfo3 != null) {
                arrayList2 = audioCacheInfo3.BOZ;
            } else {
                arrayList2 = null;
            }
            String listToString = Util.listToString(arrayList2, ",");
            StringBuilder sb2 = new StringBuilder();
            AudioCacheInfo audioCacheInfo4 = this.whj;
            if (audioCacheInfo4 != null) {
                str2 = audioCacheInfo4.BPc;
            }
            sb = sb2.append(str2).append(" - ").append(listToString).toString();
        }
        textView.setText(sb);
        AppMethodBeat.o(254498);
    }

    public final void Gt(long j2) {
        AppMethodBeat.i(254499);
        if (j2 < whm) {
            this.whi.setVisibility(0);
            this.whi.setText(this.wgq.getContext().getString(R.string.d7z, Integer.valueOf(kotlin.h.a.cR(((float) j2) / 1000.0f))));
            AppMethodBeat.o(254499);
            return;
        }
        this.whi.setVisibility(8);
        AppMethodBeat.o(254499);
    }
}
