package com.tencent.mm.plugin.finder.live.view;

import android.app.Activity;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.aws;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;

public final class i {
    private static final f uzM = g.ah(b.uzO);
    public static final a uzN = new a((byte) 0);
    private final f ufG = g.ah(new d(this));
    public h uzK;
    public HashMap<Long, aws> uzL = new HashMap<>();

    public final MMHandler getMainHandler() {
        AppMethodBeat.i(247545);
        MMHandler mMHandler = (MMHandler) this.ufG.getValue();
        AppMethodBeat.o(247545);
        return mMHandler;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(247550);
        AppMethodBeat.o(247550);
    }

    /* access modifiers changed from: package-private */
    public static final class d extends q implements kotlin.g.a.a<MMHandler> {
        final /* synthetic */ i uzP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(i iVar) {
            super(0);
            this.uzP = iVar;
        }

        static final class a implements MMHandler.Callback {
            final /* synthetic */ d uzQ;

            a(d dVar) {
                this.uzQ = dVar;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:25:0x00d8, code lost:
                if (com.tencent.f.h.RTc.aY(new com.tencent.mm.plugin.finder.live.view.i.c(r4)) == null) goto L_0x00da;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean handleMessage(android.os.Message r12) {
                /*
                // Method dump skipped, instructions count: 246
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.view.i.d.a.handleMessage(android.os.Message):boolean");
            }
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ MMHandler invoke() {
            AppMethodBeat.i(247544);
            MMHandler mMHandler = new MMHandler(Looper.getMainLooper(), new a(this));
            mMHandler.setLogging(false);
            AppMethodBeat.o(247544);
            return mMHandler;
        }
    }

    public i(Activity activity, byte[] bArr) {
        String str;
        p.h(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(247548);
        aws aws = new aws();
        if (bArr != null) {
            try {
                aws.parseFrom(bArr);
                a(aws);
            } catch (Throwable th) {
                Log.e("FinderLiveMultiTaskManager", "initMultiTaskData", th);
            }
        }
        String str2 = aws.key;
        this.uzK = new h(activity, new com.tencent.mm.plugin.multitask.a.b(activity));
        h hVar = this.uzK;
        if (str2 == null) {
            k kVar = k.vfA;
            str = k.doc();
        } else {
            str = str2;
        }
        hVar.G(21, str);
        AppMethodBeat.o(247548);
    }

    public i(Activity activity, i iVar) {
        String str;
        p.h(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(iVar, "manager");
        AppMethodBeat.i(247549);
        this.uzL = iVar.uzL;
        this.uzK = new h(activity, new com.tencent.mm.plugin.multitask.a.b(activity));
        o oVar = o.ujN;
        com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = o.dfZ();
        if (dfZ != null) {
            aws aws = this.uzL.get(Long.valueOf(dfZ.liveInfo.liveId));
            str = aws != null ? aws.key : null;
        } else {
            str = null;
        }
        h hVar = this.uzK;
        if (str == null) {
            k kVar = k.vfA;
            str = k.doc();
        }
        hVar.G(21, str);
        AppMethodBeat.o(247549);
    }

    static final class c implements Runnable {
        final /* synthetic */ i uzP;

        c(i iVar) {
            this.uzP = iVar;
        }

        public final void run() {
            AppMethodBeat.i(247542);
            this.uzP.uzK.dkj();
            AppMethodBeat.o(247542);
        }
    }

    private final void a(aws aws) {
        String str;
        AppMethodBeat.i(247546);
        if (!aws.LHu.isEmpty()) {
            LinkedList<FinderObject> linkedList = aws.LHu;
            p.g(linkedList, "originData.allHistoryFinderObjectList");
            for (T t : linkedList) {
                awe awe = t.liveInfo;
                if (awe != null) {
                    HashMap<Long, aws> hashMap = this.uzL;
                    Long valueOf = Long.valueOf(awe.liveId);
                    aws aws2 = new aws();
                    aws2.key = com.tencent.mm.ac.d.zs(awe.liveId);
                    aws2.liveId = awe.liveId;
                    aws2.hwg = t.objectNonceId;
                    aws2.hwe = t.id;
                    String str2 = t.username;
                    if (str2 == null) {
                        str2 = "";
                    }
                    aws2.hwd = str2;
                    FinderObjectDesc finderObjectDesc = t.objectDesc;
                    if (finderObjectDesc == null || (str = finderObjectDesc.description) == null) {
                        str = "";
                    }
                    aws2.desc = str;
                    aws2.sessionBuffer = t.sessionBuffer;
                    aws2.tuO = t;
                    hashMap.put(valueOf, aws2);
                }
            }
        } else if (aws.liveId != 0) {
            this.uzL.put(Long.valueOf(aws.liveId), aws);
            AppMethodBeat.o(247546);
            return;
        }
        AppMethodBeat.o(247546);
    }

    public final void diB() {
        FinderContact finderContact;
        String str;
        FinderAuthInfo finderAuthInfo = null;
        AppMethodBeat.i(247547);
        o oVar = o.ujN;
        com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = o.dfZ();
        if (dfZ != null) {
            aws aws = this.uzL.get(Long.valueOf(dfZ.liveInfo.liveId));
            if (aws == null) {
                AppMethodBeat.o(247547);
                return;
            }
            p.g(aws, "multiTaskDataMap[it.liveInfo.liveId] ?: return");
            MultiTaskInfo multiTaskInfo = this.uzK.Abp;
            if (multiTaskInfo != null) {
                FinderObject finderObject = dfZ.uDz;
                if (finderObject != null) {
                    finderContact = finderObject.contact;
                } else {
                    finderContact = null;
                }
                multiTaskInfo.field_id = com.tencent.mm.ac.d.zs(dfZ.liveInfo.liveId);
                aws.key = multiTaskInfo.field_id;
                cru erh = multiTaskInfo.erh();
                if (finderContact == null || (str = finderContact.headUrl) == null) {
                    str = "";
                }
                erh.MwR = str;
                multiTaskInfo.field_data = aws.toByteArray();
                if (finderContact != null) {
                    multiTaskInfo.erh().nickname = finderContact.nickname;
                    FinderAuthInfo finderAuthInfo2 = finderContact.authInfo;
                    if (finderAuthInfo2 != null) {
                        if (finderAuthInfo2.authIconType > 0) {
                            finderAuthInfo = finderAuthInfo2;
                        }
                        if (finderAuthInfo != null) {
                            multiTaskInfo.erh().MwS = finderAuthInfo.authIconType;
                            multiTaskInfo.erh().MwQ = finderAuthInfo.authIconUrl;
                            AppMethodBeat.o(247547);
                            return;
                        }
                    }
                    AppMethodBeat.o(247547);
                    return;
                }
                AppMethodBeat.o(247547);
                return;
            }
            AppMethodBeat.o(247547);
            return;
        }
        AppMethodBeat.o(247547);
    }

    static final class b extends q implements kotlin.g.a.a<Long> {
        public static final b uzO = new b();

        static {
            AppMethodBeat.i(247541);
            AppMethodBeat.o(247541);
        }

        b() {
            super(0);
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ Long invoke() {
            AppMethodBeat.i(247540);
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            Long valueOf = Long.valueOf(((long) com.tencent.mm.plugin.finder.storage.c.dxk().value().intValue()) * 1000);
            AppMethodBeat.o(247540);
            return valueOf;
        }
    }
}
