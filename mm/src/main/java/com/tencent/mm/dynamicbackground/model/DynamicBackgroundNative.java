package com.tencent.mm.dynamicbackground.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 11}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004H J\t\u0010\u0005\u001a\u00020\u0004H J\t\u0010\u0006\u001a\u00020\u0004H J\t\u0010\u0007\u001a\u00020\u0004H J1\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH JI\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0011H J\u0019\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nH J\u0019\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nH ¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/dynamicbackground/model/DynamicBackgroundNative;", "", "()V", "draw", "", "initView", "nativeInit", "nativeRelease", "setColor", "particleColor1", "", "particleColor2", "particleColor3", "bgColor1", "bgColor2", "setupGlslFiles", "vertexShader", "", "fragmentShader", "vertexFrameBuffer", "fragFrameBuffer", "textureVertexShader", "textureFragmentShader", "bgVertexShader", "bgFragmentShader", "surfaceChanged", "width", "height", "surfaceCreated", "dynamicbg_release"})
public final class DynamicBackgroundNative {
    public final native void draw();

    public final native void initView();

    public final native void nativeInit();

    public final native void nativeRelease();

    public final native void setColor(int i2, int i3, int i4, int i5, int i6);

    public final native void setupGlslFiles(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);

    public final native void surfaceChanged(int i2, int i3);

    public final native void surfaceCreated(int i2, int i3);

    public DynamicBackgroundNative() {
        AppMethodBeat.i(103077);
        d dVar = d.gRj;
        c atN = d.atN();
        if (atN != null) {
            atN.atD();
            AppMethodBeat.o(103077);
            return;
        }
        AppMethodBeat.o(103077);
    }
}
