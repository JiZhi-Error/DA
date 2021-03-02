package com.tencent.mm.plugin.sns.ui.f;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.background.VideoMixer;
import com.tencent.mm.plugin.recordvideo.background.b;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.e.c;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class a implements b {
    public boolean CsL = true;
    public aio FdN;
    public VideoMixer.MixConfig FdO;
    public ald FdP;
    private AbstractC1737a FdQ;
    private MMActivity gte;
    public String taskId;

    /* renamed from: com.tencent.mm.plugin.sns.ui.f.a$a  reason: collision with other inner class name */
    public interface AbstractC1737a {
        void d(CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel);
    }

    public a(MMActivity mMActivity, AbstractC1737a aVar) {
        AppMethodBeat.i(100444);
        Log.i("MicroMsg.SnsFakeVLogHelper", "SnsFakeVLogHelper");
        this.gte = mMActivity;
        this.FdQ = aVar;
        AppMethodBeat.o(100444);
    }

    @Override // com.tencent.mm.plugin.recordvideo.background.b
    public final void aAd(String str) {
        AppMethodBeat.i(100445);
        Log.i("MicroMsg.SnsFakeVLogHelper", "onInit, taskId:%s", str);
        e eVar = e.BKp;
        e.aLf(str).eIK();
        e eVar2 = e.BKp;
        e.eIW();
        this.taskId = str;
        AppMethodBeat.o(100445);
    }

    @Override // com.tencent.mm.plugin.recordvideo.background.b
    public final void eh(String str, int i2) {
        AppMethodBeat.i(100446);
        Log.i("MicroMsg.SnsFakeVLogHelper", "onRun, taskId:%s", str);
        AppMethodBeat.o(100446);
    }

    @Override // com.tencent.mm.plugin.recordvideo.background.b
    public final void aAe(String str) {
        AppMethodBeat.i(100447);
        Log.i("MicroMsg.SnsFakeVLogHelper", "onWait, taskId:%s", str);
        AppMethodBeat.o(100447);
    }

    @Override // com.tencent.mm.plugin.recordvideo.background.b
    public final void a(String str, boolean z, CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel) {
        AppMethodBeat.i(100448);
        Log.i("MicroMsg.SnsFakeVLogHelper", "onFinish,success:%b taskId:%s", Boolean.valueOf(z), str);
        if (str != null && str.equals(this.taskId)) {
            this.CsL = true;
            com.tencent.mm.plugin.recordvideo.background.a aVar = com.tencent.mm.plugin.recordvideo.background.a.BKb;
            com.tencent.mm.plugin.recordvideo.background.a.b(7, this);
            c cVar = c.Cic;
            c.c(captureVideoNormalModel);
            this.FdQ.d(captureVideoNormalModel);
        }
        AppMethodBeat.o(100448);
    }

    public final boolean fkY() {
        return !this.CsL;
    }

    public final boolean M(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(100449);
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.FdN == null);
        Log.i("MicroMsg.SnsFakeVLogHelper", "doClick %b", objArr);
        if (this.FdN == null) {
            AppMethodBeat.o(100449);
            return false;
        }
        try {
            Intent intent = new Intent(this.gte, Class.forName("com.tencent.mm.plugin.vlog.ui.fake.VLogFakePlayActivity"));
            intent.putExtra("intent_taskid", this.taskId);
            intent.putExtra("intent_thumbpath", this.FdN.thumbPath);
            intent.putExtra("sns_video_scene", 6);
            intent.putExtra("img_gallery_left", i2);
            intent.putExtra("img_gallery_top", i3);
            intent.putExtra("img_gallery_width", i4);
            intent.putExtra("img_gallery_height", i5);
            this.gte.startActivityForResult(intent, 12);
            this.gte.overridePendingTransition(0, 0);
        } catch (ClassNotFoundException e2) {
        }
        AppMethodBeat.o(100449);
        return true;
    }
}
