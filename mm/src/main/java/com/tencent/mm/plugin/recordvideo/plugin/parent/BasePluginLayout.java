package com.tencent.mm.plugin.recordvideo.plugin.parent;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.facebook.internal.NativeProtocol;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\n\b&\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u0001/B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0012\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\"\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u000eH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u000eH\u0016J\b\u0010 \u001a\u00020\u000eH\u0017J-\u0010!\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\u000e\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00020$0#2\u0006\u0010%\u001a\u00020&H\u0016¢\u0006\u0002\u0010'J\b\u0010(\u001a\u00020\u000eH\u0017J\u000e\u0010)\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u0002J\b\u0010+\u001a\u00020\u000eH\u0017J\b\u0010,\u001a\u00020\u000eH\u0016J\u0010\u0010-\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u0018H\u0017R$\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00020\tj\b\u0012\u0004\u0012\u00020\u0002`\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u00060"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "pluginList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getPluginList", "()Ljava/util/ArrayList;", "initLogic", "", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "loadCurrentPage", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "onBackPress", "", "onDetach", "onPause", "onRequestPermissionsResult", NativeProtocol.RESULT_ARGS_PERMISSIONS, "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "registerPlugin", "plugin", "release", "reset", "setVisibility", "visibility", "Companion", "plugin-recordvideo_release"})
public abstract class BasePluginLayout extends RelativeLayout implements t {
    public static final a BUe = new a((byte) 0);
    private final ArrayList<t> pluginList = new ArrayList<>();

    public abstract void a(com.tencent.mm.plugin.recordvideo.activity.a aVar, RecordConfigProvider recordConfigProvider);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BasePluginLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final String name() {
        return null;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public final ArrayList<t> getPluginList() {
        return this.pluginList;
    }

    public void a(b bVar) {
        aSs();
        reset();
        setVisibility(0);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public void onResume() {
        Iterator<T> it = this.pluginList.iterator();
        while (it.hasNext()) {
            it.next().onResume();
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public void onPause() {
        Iterator<T> it = this.pluginList.iterator();
        while (it.hasNext()) {
            it.next().onPause();
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        if (i2 == 0) {
            onResume();
        } else {
            onPause();
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public boolean onBackPress() {
        Iterator<T> it = this.pluginList.iterator();
        while (it.hasNext()) {
            if (it.next().onBackPress()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public void onActivityResult(int i2, int i3, Intent intent) {
        Iterator<T> it = this.pluginList.iterator();
        while (it.hasNext()) {
            it.next().onActivityResult(i2, i3, intent);
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public void release() {
        Iterator<T> it = this.pluginList.iterator();
        while (it.hasNext()) {
            it.next().release();
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public void reset() {
        Iterator<T> it = this.pluginList.iterator();
        while (it.hasNext()) {
            it.next().reset();
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public void aSs() {
        Iterator<T> it = this.pluginList.iterator();
        while (it.hasNext()) {
            it.next().aSs();
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public void onDetach() {
        Iterator<T> it = this.pluginList.iterator();
        while (it.hasNext()) {
            it.next().onDetach();
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        Iterator<T> it = this.pluginList.iterator();
        while (it.hasNext()) {
            it.next().onRequestPermissionsResult(i2, strArr, iArr);
        }
    }
}
