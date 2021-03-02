package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import android.os.Looper;
import android.util.SparseArray;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.d;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.eeq;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.gallery.j;
import java.util.HashMap;

public final class i extends a implements d.a, t.a, MTimerHandler.CallBack {
    private HashMap<String, j.a> Pyt;
    private boolean Pyu;
    private d pNk;

    public i(b bVar) {
        super(bVar);
        AppMethodBeat.i(36090);
        this.Pyu = false;
        this.Pyu = false;
        this.Pyt = new HashMap<>();
        o.bhj().a(this, Looper.getMainLooper());
        this.pNk = new d();
        AppMethodBeat.o(36090);
    }

    @Override // com.tencent.mm.ui.chatting.gallery.a
    public final boolean a(k kVar, ca caVar, int i2) {
        AppMethodBeat.i(36091);
        super.a(kVar, caVar, i2);
        o.bhj();
        Bitmap decodeFile = BackwardSupportUtil.BitmapFactory.decodeFile(t.Qx(caVar.field_imgPath), 1.0f);
        if (this.Pyt != null) {
            this.Pyt.put(caVar.field_imgPath, new j.a(caVar, i2));
        }
        a(kVar, false);
        ((View) kVar.gTd().PAG).setVisibility(8);
        kVar.gTd().PAH.setImageBitmap(decodeFile);
        kVar.gTd().PAH.setVisibility(0);
        kVar.gTd().PAK.setVisibility(8);
        s QN = u.QN(caVar.field_imgPath);
        kVar.PAK.setTag(QN);
        eeq eeq = QN == null ? null : QN.jsw;
        if (eeq == null) {
            kVar.thO.setVisibility(8);
        } else if (Util.isNullOrNil(eeq.iyZ)) {
            Log.i("MicroMsg.ImageGallerySightHandler", " there is no attachurl, show more info btn");
            String str = eeq.izc;
            String str2 = eeq.izd;
            if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
                kVar.thO.setVisibility(8);
            } else {
                kVar.thO.setText(str);
                kVar.thO.setVisibility(0);
                kVar.thO.setTag(caVar);
            }
        } else {
            kVar.thO.setVisibility(0);
            kVar.thO.setText(this.Pwu.Pwv.getString(R.string.h4h, new Object[]{Integer.valueOf(eeq.LxJ)}));
            String string = this.Pwu.Pwv.getString(R.string.h4h);
            if (eeq.LxJ / 60 > 0) {
                string = string + this.Pwu.Pwv.getString(R.string.h4j, new Object[]{Integer.valueOf(eeq.LxJ / 60)});
            }
            if (eeq.LxJ % 60 > 0) {
                string = string + this.Pwu.Pwv.getString(R.string.h4k, new Object[]{Integer.valueOf(eeq.LxJ % 60)});
            }
            kVar.thO.setText(string + this.Pwu.Pwv.getString(R.string.h4i));
            kVar.thO.setTag(caVar);
        }
        if (kVar.gTd().PAG instanceof VideoSightView) {
            com.tencent.mm.pluginsdk.ui.tools.u.a(kVar.thO, (VideoSightView) kVar.gTd().PAG);
        }
        AppMethodBeat.o(36091);
        return true;
    }

    public final void stopAll() {
        AppMethodBeat.i(36092);
        SparseArray<Object> sparseArray = this.Pwu.OUA;
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            int keyAt = sparseArray.keyAt(i2);
            if (!(sparseArray.get(keyAt) == null || ((View) sparseArray.get(keyAt)).getTag() == null)) {
                k kVar = (k) ((View) sparseArray.get(keyAt)).getTag();
                if (kVar.PAF != null && kVar.gTd().PAF.getVisibility() == 0) {
                    kVar.gTd().PAG.setVideoCallback(null);
                    if (((View) kVar.gTd().PAG).getVisibility() == 0 && kVar != null) {
                        a(kVar, false);
                        if (kVar.gTd().PAG != null) {
                            kVar.gTd().PAG.stop();
                        }
                        Log.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool abandonFocus");
                        this.pNk.fp(false);
                        this.Pwu.Pwv.getContext().getWindow().clearFlags(128);
                    }
                }
            }
        }
        AppMethodBeat.o(36092);
    }

    public final void anb(int i2) {
        AppMethodBeat.i(36093);
        ca amt = this.Pwu.amt(i2);
        k amM = amM(i2);
        if (amt == null || amM == null) {
            AppMethodBeat.o(36093);
            return;
        }
        s QN = u.QN(amt.field_imgPath);
        if (QN != null) {
            if (amt.field_isSend == 0) {
                if (QN.status == 113 || QN.status == 111 || QN.status == 112) {
                    a(QN, amM);
                    AppMethodBeat.o(36093);
                    return;
                } else if (QN.status == 198) {
                    a(QN, amM);
                    AppMethodBeat.o(36093);
                    return;
                }
            }
            b(amt, amM);
        }
        AppMethodBeat.o(36093);
    }

    private void a(s sVar, k kVar) {
        AppMethodBeat.i(36094);
        if (sVar == null) {
            AppMethodBeat.o(36094);
            return;
        }
        u.QK(sVar.getFileName());
        kVar.gTd().PAJ.setVisibility(0);
        kVar.gTd().PAJ.setProgress(u.g(sVar));
        o.bhj().a(this, Looper.getMainLooper());
        AppMethodBeat.o(36094);
    }

    private void b(ca caVar, final k kVar) {
        AppMethodBeat.i(36095);
        if (this.Pyu) {
            AppMethodBeat.o(36095);
            return;
        }
        kVar.gTd().PAK.setVisibility(8);
        o.bhj();
        String Qw = t.Qw(caVar.field_imgPath);
        if (caVar.gDB()) {
            Toast.makeText(this.Pwu.Pwv, (int) R.string.hwo, 0).show();
            AppMethodBeat.o(36095);
        } else if (Qw == null || !com.tencent.mm.vfs.s.YS(Qw)) {
            Toast.makeText(this.Pwu.Pwv, (int) R.string.hwo, 0).show();
            AppMethodBeat.o(36095);
        } else {
            this.Pwu.Pwv.getContext().getWindow().addFlags(128);
            Boolean bool = kVar.PAE.get(Qw);
            if (bool == null || !bool.booleanValue()) {
                ((View) kVar.gTd().PAG).setTag(Qw);
                kVar.gTd().PAI.setVisibility(8);
                kVar.gTd().PAG.stop();
                if (this.Pwu.Pwv.NQ(caVar.field_msgId) == 3) {
                    kVar.gTd().PAG.setMute(true);
                } else {
                    kVar.gTd().PAG.setMute(false);
                }
                if (kVar.gTd().PAG instanceof VideoSightView) {
                    ((VideoSightView) kVar.gTd().PAG).setIsAdVideo(b.cs(caVar));
                }
                kVar.gTd().PAG.setVideoPath(Qw);
                if (!kVar.gTd().PAG.E(this.Pwu.Pwv.getContext(), false)) {
                    kVar.gTd().PAI.setVisibility(0);
                    kVar.gTd().PAI.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.ui.chatting.gallery.i.AnonymousClass1 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(36089);
                            b bVar = new b();
                            bVar.bm(view);
                            a.b("com/tencent/mm/ui/chatting/gallery/ImageGallerySightHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            kVar.gTd().PAG.E(i.this.Pwu.Pwv.getContext(), true);
                            a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGallerySightHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(36089);
                        }
                    });
                    ((View) kVar.gTd().PAG).setVisibility(8);
                    kVar.gTd().PAH.setVisibility(0);
                } else {
                    ((View) kVar.gTd().PAG).setVisibility(0);
                    kVar.gTd().PAH.setVisibility(8);
                }
                Log.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool requestFocus");
                this.pNk.a(this);
            }
            ((View) kVar.gTd().PAG).setVisibility(0);
            AppMethodBeat.o(36095);
        }
    }

    private static void a(k kVar, boolean z) {
        AppMethodBeat.i(36096);
        if (kVar == null) {
            AppMethodBeat.o(36096);
            return;
        }
        kVar.gTd().PAJ.setVisibility(8);
        if (z) {
            kVar.gTd().PAH.setVisibility(8);
            ((View) kVar.gTd().PAG).setVisibility(0);
            AppMethodBeat.o(36096);
            return;
        }
        kVar.gTd().PAH.setVisibility(0);
        ((View) kVar.gTd().PAG).setVisibility(8);
        AppMethodBeat.o(36096);
    }

    @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
    public final boolean onTimerExpired() {
        AppMethodBeat.i(36097);
        if (this.Pwu == null) {
            AppMethodBeat.o(36097);
        } else {
            k gSh = this.Pwu.gSh();
            if (gSh == null) {
                AppMethodBeat.o(36097);
            } else if (gSh.PAF == null) {
                AppMethodBeat.o(36097);
            } else if (gSh.gTd().PAF.getVisibility() != 0) {
                AppMethodBeat.o(36097);
            } else {
                a(gSh, true);
                AppMethodBeat.o(36097);
            }
        }
        return false;
    }

    private boolean a(j.a aVar) {
        AppMethodBeat.i(36098);
        if (aVar == null) {
            AppMethodBeat.o(36098);
            return false;
        }
        o.bhj().a(this);
        if (this.Pwu.Pwv.getCurrentItem() == aVar.pos) {
            k amM = amM(aVar.pos);
            if (amM != null) {
                amM.gTd().PAJ.setVisibility(8);
            }
            AppMethodBeat.o(36098);
            return true;
        }
        this.Pwu.amU(aVar.pos);
        AppMethodBeat.o(36098);
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.gallery.a
    public final void detach() {
        AppMethodBeat.i(36099);
        stopAll();
        this.Pwu.Pwv.getContext().getWindow().clearFlags(128);
        this.Pyu = true;
        super.detach();
        this.Pyt.clear();
        this.Pyt = null;
        o.bhj().a(this);
        Log.d("MicroMsg.ImageGallerySightHandler", "mAudioHelperTool abandonFocus");
        this.pNk.fp(true);
        AppMethodBeat.o(36099);
    }

    @Override // com.tencent.mm.model.d.a
    public final void aTw() {
    }

    @Override // com.tencent.mm.model.d.a
    public final void aTx() {
    }

    @Override // com.tencent.mm.model.d.a
    public final void aTy() {
    }

    @Override // com.tencent.mm.model.d.a
    public final void aTz() {
    }

    @Override // com.tencent.mm.modelvideo.t.a
    public final void a(t.a.C0460a aVar) {
        AppMethodBeat.i(36100);
        String str = aVar.fileName;
        if (Util.isNullOrNil(str) || this.Pyt == null) {
            AppMethodBeat.o(36100);
            return;
        }
        j.a aVar2 = this.Pyt.get(str);
        if (aVar2 == null) {
            AppMethodBeat.o(36100);
            return;
        }
        ca caVar = aVar2.dCM;
        if (caVar == null || caVar.field_imgPath == null || !caVar.field_imgPath.equals(str)) {
            AppMethodBeat.o(36100);
            return;
        }
        s QN = u.QN(caVar.field_imgPath);
        if (QN == null) {
            AppMethodBeat.o(36100);
        } else if (caVar.gDB() || QN.status == 198) {
            if (a(aVar2)) {
                Toast.makeText(this.Pwu.Pwv, (int) R.string.hwo, 0).show();
            }
            AppMethodBeat.o(36100);
        } else {
            int g2 = u.g(QN);
            k amM = amM(aVar2.pos);
            if (this.Pwu.Pwv.getCurrentItem() == aVar2.pos && amM != null) {
                amM.gTd().PAJ.setVisibility(0);
                amM.gTd().PAJ.setProgress(g2);
            } else if (amM == null) {
                AppMethodBeat.o(36100);
                return;
            }
            if (g2 < amM.gTe().PAJ.getMax()) {
                AppMethodBeat.o(36100);
                return;
            }
            if (a(aVar2)) {
                b(caVar, amM);
            }
            AppMethodBeat.o(36100);
        }
    }

    public final p gSe() {
        AppMethodBeat.i(233298);
        ca gSg = this.Pwu.gSg();
        if (gSg == null) {
            Log.i("MicroMsg.ImageGallerySightHandler", "getCurResourceState, msgInfo is null");
            AppMethodBeat.o(233298);
            return null;
        } else if (gSg.gDB()) {
            Log.i("MicroMsg.ImageGallerySightHandler", "getCurResourceState, msgInfo is cleaned");
            p pVar = p.EXPIRED;
            AppMethodBeat.o(233298);
            return pVar;
        } else {
            s QN = u.QN(gSg.field_imgPath);
            if (QN == null || QN.status == 198) {
                Log.i("MicroMsg.ImageGallerySightHandler", "getCurResourceState, videoInfo is null or failed");
                p pVar2 = p.EXPIRED;
                AppMethodBeat.o(233298);
                return pVar2;
            } else if (QN.bhy()) {
                Log.i("MicroMsg.ImageGallerySightHandler", "getCurResourceState, downloaded");
                p pVar3 = p.DOWNLOADED;
                AppMethodBeat.o(233298);
                return pVar3;
            } else {
                Log.i("MicroMsg.ImageGallerySightHandler", "getCurResourceState, not downloaded");
                p pVar4 = p.NOT_DOWNLOADED;
                AppMethodBeat.o(233298);
                return pVar4;
            }
        }
    }
}
