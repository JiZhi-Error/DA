package com.tencent.tbs.one.impl.common;

import android.content.Context;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneComponent;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.TBSOneManager;
import com.tencent.tbs.one.optional.TBSOneDebugPlugin;
import com.tencent.tbs.one.optional.TBSOneRuntimeExtension;

public final class a {
    public static TBSOneRuntimeExtension a(Context context, String str) {
        AppMethodBeat.i(174191);
        TBSOneManager instance = TBSOneManager.getInstance(context, str);
        TBSOneComponent loadedComponent = instance.getLoadedComponent(ShareConstants.MEDIA_EXTENSION);
        if (loadedComponent == null) {
            try {
                loadedComponent = instance.loadComponentSync(ShareConstants.MEDIA_EXTENSION);
            } catch (TBSOneException e2) {
                TBSOneException tBSOneException = new TBSOneException(503, "Failed to load runtime extension, caused by: [" + e2.getErrorCode() + "] " + e2.getMessage(), e2.getCause());
                AppMethodBeat.o(174191);
                throw tBSOneException;
            }
        }
        if (!(loadedComponent.getEntryObject() instanceof TBSOneRuntimeExtension)) {
            TBSOneException tBSOneException2 = new TBSOneException(504, "Failed to cast the entry object of runtime extension");
            AppMethodBeat.o(174191);
            throw tBSOneException2;
        }
        TBSOneRuntimeExtension tBSOneRuntimeExtension = (TBSOneRuntimeExtension) loadedComponent.getEntryObject();
        AppMethodBeat.o(174191);
        return tBSOneRuntimeExtension;
    }

    public static void a(Context context, final TBSOneCallback<TBSOneDebugPlugin> tBSOneCallback) {
        AppMethodBeat.i(174193);
        TBSOneManager.getInstance(context, "debug").loadComponentAsync("debugger", new TBSOneCallback<TBSOneComponent>() {
            /* class com.tencent.tbs.one.impl.common.a.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.tbs.one.TBSOneCallback
            public final /* synthetic */ void onCompleted(TBSOneComponent tBSOneComponent) {
                AppMethodBeat.i(174250);
                Object entryObject = tBSOneComponent.getEntryObject();
                if (entryObject instanceof TBSOneDebugPlugin) {
                    tBSOneCallback.onCompleted((TBSOneDebugPlugin) entryObject);
                    AppMethodBeat.o(174250);
                    return;
                }
                tBSOneCallback.onError(505, "Failed to cast the entry object of debug plugin");
                AppMethodBeat.o(174250);
            }
        });
        AppMethodBeat.o(174193);
    }

    public static TBSOneRuntimeExtension b(Context context, String str) {
        AppMethodBeat.i(174192);
        TBSOneComponent loadedComponent = TBSOneManager.getInstance(context, str).getLoadedComponent(ShareConstants.MEDIA_EXTENSION);
        if (loadedComponent == null || !(loadedComponent.getEntryObject() instanceof TBSOneRuntimeExtension)) {
            AppMethodBeat.o(174192);
            return null;
        }
        TBSOneRuntimeExtension tBSOneRuntimeExtension = (TBSOneRuntimeExtension) loadedComponent.getEntryObject();
        AppMethodBeat.o(174192);
        return tBSOneRuntimeExtension;
    }
}
