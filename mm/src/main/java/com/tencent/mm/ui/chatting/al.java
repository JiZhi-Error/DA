package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.f;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.sw;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.gallery.b;
import com.tencent.mm.ui.chatting.gallery.d;
import java.lang.ref.WeakReference;

public final class al extends IListener<sw> {
    private a Pkh = null;
    private WeakReference<Activity> kRw;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(sw swVar) {
        AppMethodBeat.i(34882);
        boolean a2 = a(swVar);
        AppMethodBeat.o(34882);
        return a2;
    }

    public al(a aVar, Activity activity) {
        super(0);
        AppMethodBeat.i(34879);
        this.Pkh = aVar;
        this.kRw = new WeakReference<>(activity);
        this.__eventId = sw.class.getName().hashCode();
        AppMethodBeat.o(34879);
    }

    private boolean a(sw swVar) {
        ca caVar;
        boolean z;
        AppMethodBeat.i(34880);
        final Activity activity = this.kRw.get();
        if (!(this.Pkh == null || swVar == null || !(swVar instanceof sw) || activity == null)) {
            long j2 = swVar.dZp.msgId;
            String str = swVar.dZp.dZq;
            ca caVar2 = swVar.dZp.dZr;
            if (caVar2 == null || caVar2.field_msgId <= 0) {
                caVar = swVar.dZp.dZr;
            } else {
                caVar = caVar2;
            }
            if (caVar != null) {
                switch (caVar.getType()) {
                    case 3:
                        switch (this.Pkh) {
                            case IMAGE_GALLERY_UI:
                                if (caVar != null && caVar.field_msgId > 0) {
                                    try {
                                        f.baQ().Oc(c.a("downimg", caVar.field_createTime, caVar.field_talker, new StringBuilder().append(caVar.field_msgId).toString()));
                                        Log.i("MicroMsg.RevokeMsgListener", "[oneliang][revokeMsgImage] cancel result:%s", Boolean.TRUE);
                                        bg.azz().cancel(109);
                                        q.bcS().C(d.k(caVar).localId, j2);
                                    } catch (Exception e2) {
                                        Log.printErrStackTrace("MicroMsg.RevokeMsgListener", e2, "[oneliang][revokeMsgImage] cancel failure:%s", e2.getMessage());
                                    }
                                }
                                if (activity != null && (activity instanceof ImageGalleryUI)) {
                                    ImageGalleryUI imageGalleryUI = (ImageGalleryUI) activity;
                                    Log.i("MicroMsg.RevokeMsgListener", "[oneliang][revokeMsgImage] image gallery ui,msg id is:%s,downloadingImageMsgId: %s", Long.valueOf(j2), Long.valueOf(imageGalleryUI.msgId));
                                    if (j2 == imageGalleryUI.msgId) {
                                        h.a((Context) activity, str, "", false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                            /* class com.tencent.mm.ui.chatting.al.AnonymousClass1 */

                                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                                AppMethodBeat.i(34873);
                                                dialogInterface.dismiss();
                                                activity.finish();
                                                AppMethodBeat.o(34873);
                                            }
                                        });
                                        break;
                                    }
                                }
                                break;
                        }
                    case 43:
                    case 62:
                        Object[] objArr = new Object[2];
                        objArr[0] = this.Pkh;
                        objArr[1] = Boolean.valueOf(Looper.myLooper() == bg.aAk().getLooper());
                        Log.v("MicroMsg.RevokeMsgListener", "ashutest::revoke msg, type %s, isWorkerThread %B", objArr);
                        switch (this.Pkh) {
                            case VIDEO_GALLERY:
                                bO(caVar);
                                if (activity instanceof ImageGalleryUI) {
                                    ImageGalleryUI imageGalleryUI2 = (ImageGalleryUI) activity;
                                    if (imageGalleryUI2.Pwu == null || !b.m(caVar) || caVar.field_msgId != imageGalleryUI2.Pwu.gSg().field_msgId) {
                                        z = false;
                                    } else {
                                        z = true;
                                    }
                                    if (z) {
                                        imageGalleryUI2.ang(imageGalleryUI2.getCurrentItem());
                                        h.a((Context) activity, str, "", false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                            /* class com.tencent.mm.ui.chatting.al.AnonymousClass2 */

                                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                                AppMethodBeat.i(34874);
                                                dialogInterface.dismiss();
                                                activity.finish();
                                                AppMethodBeat.o(34874);
                                            }
                                        });
                                        break;
                                    }
                                }
                                break;
                            case CHATTING_ITEM_VIDEO:
                                bO(caVar);
                                break;
                        }
                }
            } else {
                Log.e("MicroMsg.RevokeMsgListener", "in callback msgInfo null");
                AppMethodBeat.o(34880);
                return false;
            }
        }
        AppMethodBeat.o(34880);
        return false;
    }

    public enum a {
        CHATTING_ITEM_VIDEO,
        IMAGE_GALLERY_UI,
        VIDEO_GALLERY;

        public static a valueOf(String str) {
            AppMethodBeat.i(34877);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(34877);
            return aVar;
        }

        static {
            AppMethodBeat.i(34878);
            AppMethodBeat.o(34878);
        }
    }

    private static void bO(ca caVar) {
        AppMethodBeat.i(34881);
        s QN = u.QN(caVar.field_imgPath);
        if (QN != null) {
            try {
                f.baQ().Oc(c.a("downvideo", QN.createTime, QN.getUser(), QN.getFileName()));
                Log.i("MicroMsg.RevokeMsgListener", "ashutest::[oneliang][revokeMsgVideo] cancel result:%s", Boolean.TRUE);
                o.bho().bhH();
                bp.z(caVar);
                AppMethodBeat.o(34881);
                return;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.RevokeMsgListener", e2, "[oneliang][revokeMsgVideo] chatting item video,cancel failure:%s", e2.getMessage());
            }
        }
        AppMethodBeat.o(34881);
    }
}
