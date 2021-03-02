package com.tencent.mm.plugin.story.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.story.c.a.e;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.ui.view.UserGuideView;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@com.tencent.mm.ui.base.a(3)
@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/StoryCaptureUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "guideView", "Lcom/tencent/mm/plugin/story/ui/view/UserGuideView;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-story_release"})
public final class StoryCaptureUI extends MMActivity {
    public static final a FwU = new a((byte) 0);
    private UserGuideView FwT;

    static {
        AppMethodBeat.i(119629);
        AppMethodBeat.o(119629);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/StoryCaptureUI$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.bzg;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(119628);
        supportRequestWindowFeature(1);
        super.onCreate(bundle);
        setSelfNavigationBarVisible(8);
        getWindow().addFlags(2097280);
        getWindow().setFlags(201327616, 201327616);
        d.rb(true);
        this.FwT = (UserGuideView) findViewById(R.id.i7u);
        UserGuideView userGuideView = this.FwT;
        if (userGuideView != null) {
            userGuideView.setClickListener(new b(this));
        }
        h hVar = h.FuH;
        h.fqm().sj(1);
        h hVar2 = h.FuH;
        h.fqn();
        AppMethodBeat.o(119628);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ StoryCaptureUI FwV;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(StoryCaptureUI storyCaptureUI) {
            super(0);
            this.FwV = storyCaptureUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            long j2 = 0;
            int i2 = 0;
            AppMethodBeat.i(119627);
            if (e.Fln.fng()) {
                com.tencent.mm.kernel.e aAh = g.aAh();
                p.g(aAh, "storage()");
                aAh.azQ().set(ar.a.USERINFO_STORY_CAPTURE_FIRST_NEW_BOOLEAN_SYNC, Boolean.TRUE);
            } else {
                com.tencent.mm.kernel.e aAh2 = g.aAh();
                p.g(aAh2, "storage()");
                aAh2.azQ().set(ar.a.USERINFO_STORY_CAPTURE_FIRST_BOOLEAN_SYNC, Boolean.TRUE);
            }
            com.tencent.mm.plugin.story.f.e.a aVar = com.tencent.mm.plugin.story.f.e.a.Fpl;
            AppCompatActivity context = this.FwV.getContext();
            Intent intent = this.FwV.getIntent();
            if (intent != null) {
                i2 = intent.getIntExtra("jump_page_from", 0);
            }
            Intent intent2 = this.FwV.getIntent();
            if (intent2 != null) {
                j2 = intent2.getLongExtra("video_object_id", 0);
            }
            aVar.startStoryCapture(context, i2, j2);
            this.FwV.finish();
            x xVar = x.SXb;
            AppMethodBeat.o(119627);
            return xVar;
        }
    }
}
