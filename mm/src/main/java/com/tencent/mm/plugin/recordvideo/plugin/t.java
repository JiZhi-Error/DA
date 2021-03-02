package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J-\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0007H\u0016¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "", "name", "", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "onBackPress", "", "onDetach", "onPause", "onRequestPermissionsResult", NativeProtocol.RESULT_ARGS_PERMISSIONS, "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "release", "reset", "setVisibility", "visibility", "plugin-recordvideo_release"})
public interface t {
    void aSs();

    String name();

    void onActivityResult(int i2, int i3, Intent intent);

    boolean onBackPress();

    void onDetach();

    void onPause();

    void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr);

    void onResume();

    void release();

    void reset();

    void setVisibility(int i2);

    @l(hxD = {1, 1, 16})
    public static final class a {
        public static void a(String[] strArr, int[] iArr) {
            AppMethodBeat.i(237301);
            p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
            p.h(iArr, "grantResults");
            AppMethodBeat.o(237301);
        }
    }
}
