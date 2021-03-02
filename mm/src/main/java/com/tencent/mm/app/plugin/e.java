package com.tencent.mm.app.plugin;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.plugin.URISpanHandlerSet;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.d;
import com.tencent.mm.pluginsdk.ui.span.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;

public final class e implements d {
    private static e dnR = null;
    private URISpanHandlerSet dnS;
    private ArrayList<URISpanHandlerSet.BaseUriSpanHandler> dnT = new ArrayList<>();
    private ArrayList<URISpanHandlerSet.BaseUriSpanHandler> dnU = new ArrayList<>();
    private ArrayList<URISpanHandlerSet.BaseUriSpanHandler> dnV = new ArrayList<>();
    private Context mContext = null;

    public static e Xo() {
        AppMethodBeat.i(19668);
        if (dnR == null) {
            dnR = new e();
        }
        e eVar = dnR;
        AppMethodBeat.o(19668);
        return eVar;
    }

    private e() {
        AppMethodBeat.i(19669);
        long nowMilliSecond = Util.nowMilliSecond();
        Log.d("MicroMsg.URISpanHandler", "init URISpanHandler");
        this.mContext = MMApplicationContext.getContext();
        this.dnS = new URISpanHandlerSet(this.mContext);
        Class<?>[] declaredClasses = URISpanHandlerSet.class.getDeclaredClasses();
        for (Class<?> cls : declaredClasses) {
            if (cls != null && cls.getSuperclass() != null && cls.isAnnotationPresent(URISpanHandlerSet.a.class) && cls.getSuperclass().getName().equals(URISpanHandlerSet.BaseUriSpanHandler.class.getName())) {
                try {
                    URISpanHandlerSet.a aVar = (URISpanHandlerSet.a) cls.getAnnotation(URISpanHandlerSet.a.class);
                    Constructor<?> declaredConstructor = cls.getDeclaredConstructor(URISpanHandlerSet.class);
                    if (declaredConstructor != null) {
                        URISpanHandlerSet.BaseUriSpanHandler baseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler) URISpanHandlerSet.BaseUriSpanHandler.class.cast(declaredConstructor.newInstance(this.dnS));
                        URISpanHandlerSet.PRIORITY Xq = aVar.Xq();
                        if (Xq == URISpanHandlerSet.PRIORITY.LOW) {
                            this.dnV.add(baseUriSpanHandler);
                        } else if (Xq == URISpanHandlerSet.PRIORITY.NORMAL) {
                            this.dnU.add(baseUriSpanHandler);
                        } else if (Xq == URISpanHandlerSet.PRIORITY.HIGH) {
                            this.dnT.add(baseUriSpanHandler);
                        }
                        Log.d("MicroMsg.URISpanHandler", "successfully add: %s", cls.getName());
                    } else {
                        Log.d("MicroMsg.URISpanHandler", "failed to add %s, constructor is null!!", cls.getName());
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.URISpanHandler", e2, "", new Object[0]);
                    Log.d("MicroMsg.URISpanHandler", "add %s error: %s, errorType:%s", cls.getName(), e2.getMessage(), e2.getClass().getName());
                } catch (Error e3) {
                    Log.printErrStackTrace("MicroMsg.URISpanHandler", e3, "", new Object[0]);
                    Log.d("MicroMsg.URISpanHandler", "add %s error: %s, errorType:%s", cls.getName(), e3.getMessage(), e3.getClass().getName());
                }
            }
        }
        Log.d("MicroMsg.URISpanHandler", "init URISpanHandler used :%d ms", Long.valueOf(Util.nowMilliSecond() - nowMilliSecond));
        AppMethodBeat.o(19669);
    }

    @Override // com.tencent.mm.pluginsdk.ui.span.d
    public final u w(Context context, String str) {
        AppMethodBeat.i(19670);
        Log.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, url:%s, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size:%d, mLowPriorityHandlerList.size：%d", str, Integer.valueOf(this.dnT.size()), Integer.valueOf(this.dnU.size()), Integer.valueOf(this.dnV.size()));
        if (context == null) {
            Log.e("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl error, context is null!");
            this.dnS.mContext = null;
            AppMethodBeat.o(19670);
            return null;
        }
        this.mContext = context;
        this.dnS.mContext = this.mContext;
        if (Util.isNullOrNil(str)) {
            Log.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, url is null");
            this.mContext = null;
            this.dnS.mContext = null;
            AppMethodBeat.o(19670);
            return null;
        }
        Iterator<URISpanHandlerSet.BaseUriSpanHandler> it = this.dnT.iterator();
        while (it.hasNext()) {
            u gx = it.next().gx(str);
            if (gx != null) {
                Log.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", Integer.valueOf(gx.type));
                this.mContext = null;
                this.dnS.mContext = null;
                AppMethodBeat.o(19670);
                return gx;
            }
        }
        Iterator<URISpanHandlerSet.BaseUriSpanHandler> it2 = this.dnU.iterator();
        while (it2.hasNext()) {
            u gx2 = it2.next().gx(str);
            if (gx2 != null) {
                Log.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", Integer.valueOf(gx2.type));
                this.mContext = null;
                this.dnS.mContext = null;
                AppMethodBeat.o(19670);
                return gx2;
            }
        }
        Iterator<URISpanHandlerSet.BaseUriSpanHandler> it3 = this.dnV.iterator();
        while (it3.hasNext()) {
            u gx3 = it3.next().gx(str);
            if (gx3 != null) {
                Log.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", Integer.valueOf(gx3.type));
                this.mContext = null;
                this.dnS.mContext = null;
                AppMethodBeat.o(19670);
                return gx3;
            }
        }
        this.mContext = null;
        this.dnS.mContext = null;
        Log.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, nothing match");
        AppMethodBeat.o(19670);
        return null;
    }

    @Override // com.tencent.mm.pluginsdk.ui.span.d
    public final boolean a(Context context, View view, u uVar, i iVar) {
        AppMethodBeat.i(231414);
        if (uVar == null) {
            Log.d("MicroMsg.URISpanHandler", "handleSpanClick, hrefInfo is null");
            AppMethodBeat.o(231414);
            return false;
        }
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(uVar.type);
        objArr[1] = Boolean.valueOf(iVar == null);
        objArr[2] = Integer.valueOf(this.dnT.size());
        objArr[3] = Integer.valueOf(this.dnU.size());
        objArr[4] = Integer.valueOf(this.dnV.size());
        Log.d("MicroMsg.URISpanHandler", "handleSpanClick, hrefInfo.getType:%d, callback==null:%b, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size:%d, mLowPriorityHandlerList.size:%d", objArr);
        if (context == null) {
            Log.e("MicroMsg.URISpanHandler", "handleSpanClick, context is null!");
            this.dnS.mContext = null;
            AppMethodBeat.o(231414);
            return false;
        }
        this.mContext = context;
        this.dnS.mContext = this.mContext;
        Iterator<URISpanHandlerSet.BaseUriSpanHandler> it = this.dnT.iterator();
        while (it.hasNext()) {
            URISpanHandlerSet.BaseUriSpanHandler next = it.next();
            if (contains(next.Xp(), uVar.type) && next.a(view, uVar, iVar)) {
                Log.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", next.getClass().getName());
                this.mContext = null;
                this.dnS.mContext = null;
                AppMethodBeat.o(231414);
                return true;
            }
        }
        Iterator<URISpanHandlerSet.BaseUriSpanHandler> it2 = this.dnU.iterator();
        while (it2.hasNext()) {
            URISpanHandlerSet.BaseUriSpanHandler next2 = it2.next();
            if (contains(next2.Xp(), uVar.type) && next2.a(view, uVar, iVar)) {
                Log.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", next2.getClass().getName());
                this.mContext = null;
                this.dnS.mContext = null;
                AppMethodBeat.o(231414);
                return true;
            }
        }
        Iterator<URISpanHandlerSet.BaseUriSpanHandler> it3 = this.dnV.iterator();
        while (it3.hasNext()) {
            URISpanHandlerSet.BaseUriSpanHandler next3 = it3.next();
            if (contains(next3.Xp(), uVar.type) && next3.a(view, uVar, iVar)) {
                Log.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", next3.getClass().getName());
                this.mContext = null;
                this.dnS.mContext = null;
                AppMethodBeat.o(231414);
                return true;
            }
        }
        this.mContext = null;
        this.dnS.mContext = null;
        Log.d("MicroMsg.URISpanHandler", "handleSpanClick, nothing handle");
        AppMethodBeat.o(231414);
        return false;
    }

    public final boolean b(Context context, String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
        AppMethodBeat.i(19672);
        Object[] objArr = new Object[6];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Boolean.valueOf(uVar == null);
        objArr[3] = Integer.valueOf(this.dnT.size());
        objArr[4] = Integer.valueOf(this.dnU.size());
        objArr[5] = Integer.valueOf(this.dnV.size());
        Log.d("MicroMsg.URISpanHandler", "handleUriJump, url:%s, isAllowScanQrCode:%b, callback==null:%b, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size: %d, mLowPriorityHandlerList.size: %d", objArr);
        if (context == null) {
            Log.e("MicroMsg.URISpanHandler", "handleUriJump, context is null!");
            this.dnS.mContext = null;
            AppMethodBeat.o(19672);
            return false;
        }
        this.mContext = context;
        this.dnS.mContext = this.mContext;
        if (Util.isNullOrNil(str)) {
            Log.d("MicroMsg.URISpanHandler", "handleUriJump, url is null");
            this.mContext = null;
            this.dnS.mContext = null;
            AppMethodBeat.o(19672);
            return false;
        }
        Iterator<URISpanHandlerSet.BaseUriSpanHandler> it = this.dnT.iterator();
        while (it.hasNext()) {
            URISpanHandlerSet.BaseUriSpanHandler next = it.next();
            if (next.a(str, z, uVar, bundle)) {
                Log.d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", next.getClass().getName());
                this.mContext = null;
                this.dnS.mContext = null;
                AppMethodBeat.o(19672);
                return true;
            }
        }
        Iterator<URISpanHandlerSet.BaseUriSpanHandler> it2 = this.dnU.iterator();
        while (it2.hasNext()) {
            URISpanHandlerSet.BaseUriSpanHandler next2 = it2.next();
            if (next2.a(str, z, uVar, bundle)) {
                Log.d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", next2.getClass().getName());
                this.mContext = null;
                this.dnS.mContext = null;
                AppMethodBeat.o(19672);
                return true;
            }
        }
        Iterator<URISpanHandlerSet.BaseUriSpanHandler> it3 = this.dnV.iterator();
        while (it3.hasNext()) {
            URISpanHandlerSet.BaseUriSpanHandler next3 = it3.next();
            if (next3.a(str, z, uVar, bundle)) {
                Log.d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", next3.getClass().getName());
                this.mContext = null;
                this.dnS.mContext = null;
                AppMethodBeat.o(19672);
                return true;
            }
        }
        this.mContext = null;
        this.dnS.mContext = null;
        Log.d("MicroMsg.URISpanHandler", "handleUriJump, nothing handle");
        AppMethodBeat.o(19672);
        return false;
    }

    private static boolean contains(int[] iArr, int i2) {
        for (int i3 : iArr) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }
}
