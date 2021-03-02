package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.vlog.model.w;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001b\u001a\u00020\u00192\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0019H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditImageAddMusicPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/MultiEditAddMusicPlugin$AudioStateListener;", "layout", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "addMusicGroup", "Landroid/view/View;", "addMusicIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "addMusicIndicator", "addMusicText", "Landroid/widget/TextView;", "hasLocal", "", "hasMusic", "getLayout", "()Landroid/view/ViewGroup;", "musicInfo", "Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "onAudioPause", "", "onAudioResume", "setMusic", "setVisibility", "visibility", "", "updateContent", "plugin-vlog_release"})
public final class d implements t {
    private final WeImageView GGH;
    private boolean GGI;
    private final ViewGroup wgq;
    final com.tencent.mm.plugin.recordvideo.plugin.parent.d wgr;
    private final View whe;
    private final WeImageView whf;
    private final TextView whg;
    private AudioCacheInfo whj;
    private boolean whk;

    public d(ViewGroup viewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.d dVar) {
        p.h(viewGroup, "layout");
        p.h(dVar, "status");
        AppMethodBeat.i(191217);
        this.wgq = viewGroup;
        this.wgr = dVar;
        View findViewById = this.wgq.findViewById(R.id.bvt);
        p.g(findViewById, "layout.findViewById(R.id.edit_image_add_music)");
        this.whe = findViewById;
        View findViewById2 = this.wgq.findViewById(R.id.duy);
        p.g(findViewById2, "layout.findViewById(R.id.image_add_music_text)");
        this.whg = (TextView) findViewById2;
        View findViewById3 = this.wgq.findViewById(R.id.duw);
        p.g(findViewById3, "layout.findViewById(R.id.image_add_music_icon)");
        this.whf = (WeImageView) findViewById3;
        View findViewById4 = this.wgq.findViewById(R.id.dux);
        p.g(findViewById4, "layout.findViewById(R.id…mage_add_music_indicator)");
        this.GGH = (WeImageView) findViewById4;
        this.whe.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.d.AnonymousClass1 */
            final /* synthetic */ d GGJ;

            {
                this.GGJ = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(191213);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/vlog/ui/plugin/EditImageAddMusicPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                d.b.a(this.GGJ.wgr, d.c.BWV);
                a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/EditImageAddMusicPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(191213);
            }
        });
        this.whg.setMaxWidth(com.tencent.mm.cb.a.jn(this.wgq.getContext()) - com.tencent.mm.cb.a.fromDPToPix(this.wgq.getContext(), 206));
        AppMethodBeat.o(191217);
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
        AppMethodBeat.i(191218);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(191218);
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

    public final void f(AudioCacheInfo audioCacheInfo) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(191214);
        this.whj = audioCacheInfo;
        if (audioCacheInfo != null) {
            z = true;
        } else {
            z = false;
        }
        this.whk = z;
        if (audioCacheInfo != null) {
            z2 = audioCacheInfo.BPb;
        }
        this.GGI = z2;
        dFW();
        AppMethodBeat.o(191214);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
        AppMethodBeat.i(191215);
        if (!w.fBt()) {
            this.whe.setVisibility(8);
            AppMethodBeat.o(191215);
            return;
        }
        if (this.whe.getVisibility() != i2) {
            this.whe.setVisibility(i2);
            if (this.whe.getVisibility() == 0) {
                dFW();
            }
        }
        AppMethodBeat.o(191215);
    }

    private final void dFW() {
        ArrayList<String> arrayList;
        ArrayList<String> arrayList2;
        String sb;
        String str;
        String str2 = null;
        AppMethodBeat.i(191216);
        if (this.whk || this.GGI) {
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
            AppMethodBeat.o(191216);
            return;
        }
        this.whg.setText(R.string.bq1);
        AppMethodBeat.o(191216);
    }
}
