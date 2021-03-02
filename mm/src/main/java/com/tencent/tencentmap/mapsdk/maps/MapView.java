package com.tencent.tencentmap.mapsdk.maps;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.map.internal.a;
import com.tencent.map.lib.JNIInterface;
import com.tencent.map.tools.Callback;
import com.tencent.map.tools.sheet.SheetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.BaseMapView;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;

public class MapView extends BaseMapView {
    private TencentMap mMap;
    private BaseMapView.MapViewProxy mMapDelegate;
    private TencentMapOptions mMapOptions;

    static {
        AppMethodBeat.i(181027);
        System.loadLibrary(JNIInterface.LIB_NAME);
        AppMethodBeat.o(181027);
    }

    public MapView(Context context) {
        this(context, new TencentMapOptions());
        AppMethodBeat.i(181008);
        AppMethodBeat.o(181008);
    }

    public MapView(Context context, TencentMapOptions tencentMapOptions) {
        super(context);
        AppMethodBeat.i(181009);
        this.mMap = getMap(tencentMapOptions);
        AppMethodBeat.o(181009);
    }

    public MapView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, new TencentMapOptions());
        AppMethodBeat.i(193597);
        AppMethodBeat.o(193597);
    }

    public MapView(Context context, AttributeSet attributeSet, TencentMapOptions tencentMapOptions) {
        this(context, attributeSet, 0, tencentMapOptions);
    }

    public MapView(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, new TencentMapOptions());
        AppMethodBeat.i(181010);
        AppMethodBeat.o(181010);
    }

    public MapView(Context context, AttributeSet attributeSet, int i2, TencentMapOptions tencentMapOptions) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(193598);
        this.mMap = getMap(tencentMapOptions);
        AppMethodBeat.o(193598);
    }

    private void initMap(TencentMapOptions tencentMapOptions) {
        AppMethodBeat.i(181011);
        if (this.mMap == null || (this.mMapOptions != tencentMapOptions && !this.mMapOptions.equals(tencentMapOptions))) {
            if (tencentMapOptions == null) {
                tencentMapOptions = new TencentMapOptions();
            }
            if (tencentMapOptions.getMapViewType() == null) {
                tencentMapOptions.setMapViewType(getViewType());
            }
            if (tencentMapOptions.getMapKernel() == null) {
                tencentMapOptions.setMapKernel(getMapKernel());
            }
            setClickable(true);
            if (!(this.mMap == null || this.mMapDelegate == null)) {
                this.mMapDelegate.onPause();
                this.mMapDelegate.onStop();
                this.mMapDelegate.onDestroy();
                this.mMapDelegate = null;
                this.mMap = null;
            }
            final Callback<TencentMap> mapAsyncCallback = tencentMapOptions.getMapAsyncCallback();
            if (this.mMapDelegate == null) {
                a aVar = new a(getContext().getApplicationContext(), tencentMapOptions);
                if (mapAsyncCallback != null) {
                    SheetManager.getInstance().initAsync(aVar.f1299b, aVar.f1298a, 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0084: INVOKE  
                          (wrap: com.tencent.map.tools.sheet.SheetManager : 0x0077: INVOKE  (r0v8 com.tencent.map.tools.sheet.SheetManager) =  type: STATIC call: com.tencent.map.tools.sheet.SheetManager.getInstance():com.tencent.map.tools.sheet.SheetManager)
                          (wrap: android.content.Context : 0x007b: IGET  (r3v1 android.content.Context) = (r1v2 'aVar' com.tencent.map.internal.a) com.tencent.map.internal.a.b android.content.Context)
                          (wrap: com.tencent.map.tools.sheet.SheetManager$Options : 0x007d: IGET  (r4v0 com.tencent.map.tools.sheet.SheetManager$Options) = (r1v2 'aVar' com.tencent.map.internal.a) com.tencent.map.internal.a.a com.tencent.map.tools.sheet.SheetManager$Options)
                          (wrap: com.tencent.map.internal.a$1 : 0x0081: CONSTRUCTOR  (r5v0 com.tencent.map.internal.a$1) = 
                          (r1v2 'aVar' com.tencent.map.internal.a)
                          (r7v0 'this' com.tencent.tencentmap.mapsdk.maps.MapView A[IMMUTABLE_TYPE, THIS])
                          (r8v1 'tencentMapOptions' com.tencent.tencentmap.mapsdk.maps.TencentMapOptions)
                          (wrap: com.tencent.tencentmap.mapsdk.maps.MapView$1 : 0x0074: CONSTRUCTOR  (r2v3 com.tencent.tencentmap.mapsdk.maps.MapView$1) = 
                          (r7v0 'this' com.tencent.tencentmap.mapsdk.maps.MapView A[IMMUTABLE_TYPE, THIS])
                          (r0v5 'mapAsyncCallback' com.tencent.map.tools.Callback<com.tencent.tencentmap.mapsdk.maps.TencentMap> A[SKIP_ARG])
                         call: com.tencent.tencentmap.mapsdk.maps.MapView.1.<init>(com.tencent.tencentmap.mapsdk.maps.MapView, com.tencent.map.tools.Callback):void type: CONSTRUCTOR)
                         call: com.tencent.map.internal.a.1.<init>(com.tencent.map.internal.a, android.view.ViewGroup, com.tencent.tencentmap.mapsdk.maps.TencentMapOptions, com.tencent.map.tools.Callback):void type: CONSTRUCTOR)
                         type: VIRTUAL call: com.tencent.map.tools.sheet.SheetManager.initAsync(android.content.Context, com.tencent.map.tools.sheet.SheetManager$Options, com.tencent.map.tools.Callback):void in method: com.tencent.tencentmap.mapsdk.maps.MapView.initMap(com.tencent.tencentmap.mapsdk.maps.TencentMapOptions):void, file: classes8.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0081: CONSTRUCTOR  (r5v0 com.tencent.map.internal.a$1) = 
                          (r1v2 'aVar' com.tencent.map.internal.a)
                          (r7v0 'this' com.tencent.tencentmap.mapsdk.maps.MapView A[IMMUTABLE_TYPE, THIS])
                          (r8v1 'tencentMapOptions' com.tencent.tencentmap.mapsdk.maps.TencentMapOptions)
                          (wrap: com.tencent.tencentmap.mapsdk.maps.MapView$1 : 0x0074: CONSTRUCTOR  (r2v3 com.tencent.tencentmap.mapsdk.maps.MapView$1) = 
                          (r7v0 'this' com.tencent.tencentmap.mapsdk.maps.MapView A[IMMUTABLE_TYPE, THIS])
                          (r0v5 'mapAsyncCallback' com.tencent.map.tools.Callback<com.tencent.tencentmap.mapsdk.maps.TencentMap> A[SKIP_ARG])
                         call: com.tencent.tencentmap.mapsdk.maps.MapView.1.<init>(com.tencent.tencentmap.mapsdk.maps.MapView, com.tencent.map.tools.Callback):void type: CONSTRUCTOR)
                         call: com.tencent.map.internal.a.1.<init>(com.tencent.map.internal.a, android.view.ViewGroup, com.tencent.tencentmap.mapsdk.maps.TencentMapOptions, com.tencent.map.tools.Callback):void type: CONSTRUCTOR in method: com.tencent.tencentmap.mapsdk.maps.MapView.initMap(com.tencent.tencentmap.mapsdk.maps.TencentMapOptions):void, file: classes8.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 31 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.map.internal.a, state: GENERATED_AND_UNLOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 37 more
                        */
                    /*
                    // Method dump skipped, instructions count: 159
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.tencentmap.mapsdk.maps.MapView.initMap(com.tencent.tencentmap.mapsdk.maps.TencentMapOptions):void");
                }

                @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView
                public TencentMap getMap() {
                    AppMethodBeat.i(181012);
                    if (this.mMap != null) {
                        TencentMap tencentMap = this.mMap;
                        AppMethodBeat.o(181012);
                        return tencentMap;
                    }
                    TencentMap map = getMap(this.mMapOptions);
                    AppMethodBeat.o(181012);
                    return map;
                }

                @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView
                public TencentMap getMap(TencentMapOptions tencentMapOptions) {
                    AppMethodBeat.i(181013);
                    initMap(tencentMapOptions);
                    if (this.mMapDelegate != null) {
                        TencentMap map = this.mMapDelegate.getMap();
                        AppMethodBeat.o(181013);
                        return map;
                    }
                    AppMethodBeat.o(181013);
                    return null;
                }

                private <T extends TencentMap> void getMapSync(TencentMapOptions tencentMapOptions, final Callback<T> callback) {
                    AppMethodBeat.i(181014);
                    tencentMapOptions.setGetMapAsync(new Callback<TencentMap>() {
                        /* class com.tencent.tencentmap.mapsdk.maps.MapView.AnonymousClass2 */

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // com.tencent.map.tools.Callback
                        public final /* synthetic */ void callback(TencentMap tencentMap) {
                            AppMethodBeat.i(181007);
                            final TencentMap tencentMap2 = tencentMap;
                            tencentMap2.addOnMapLoadedCallback(new TencentMap.OnMapLoadedCallback() {
                                /* class com.tencent.tencentmap.mapsdk.maps.MapView.AnonymousClass2.AnonymousClass1 */

                                @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLoadedCallback
                                public final void onMapLoaded() {
                                    AppMethodBeat.i(181006);
                                    if (callback != null) {
                                        callback.callback(tencentMap2);
                                    }
                                    tencentMap2.removeOnMapLoadedCallback(this);
                                    AppMethodBeat.o(181006);
                                }
                            });
                            AppMethodBeat.o(181007);
                        }
                    });
                    initMap(tencentMapOptions);
                    AppMethodBeat.o(181014);
                }

                public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                    AppMethodBeat.i(193599);
                    if (this.mMapDelegate == null || !this.mMapDelegate.isTouchable()) {
                        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
                        AppMethodBeat.o(193599);
                        return onInterceptTouchEvent;
                    }
                    boolean onInterceptTouchEvent2 = this.mMapDelegate.onInterceptTouchEvent(motionEvent);
                    getParent().requestDisallowInterceptTouchEvent(onInterceptTouchEvent2);
                    AppMethodBeat.o(193599);
                    return onInterceptTouchEvent2;
                }

                public final boolean onTouchEvent(MotionEvent motionEvent) {
                    AppMethodBeat.i(181015);
                    if (this.mMapDelegate == null || !this.mMapDelegate.isTouchable()) {
                        boolean onTouchEvent = super.onTouchEvent(motionEvent);
                        AppMethodBeat.o(181015);
                        return onTouchEvent;
                    }
                    boolean onTouchEvent2 = this.mMapDelegate.onTouchEvent(motionEvent);
                    AppMethodBeat.o(181015);
                    return onTouchEvent2;
                }

                @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView
                public void onStart() {
                    AppMethodBeat.i(181016);
                    if (this.mMapDelegate != null) {
                        this.mMapDelegate.onStart();
                    }
                    AppMethodBeat.o(181016);
                }

                @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView
                public void onResume() {
                    AppMethodBeat.i(181017);
                    if (this.mMapDelegate != null) {
                        this.mMapDelegate.onResume();
                    }
                    AppMethodBeat.o(181017);
                }

                @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView
                public void onPause() {
                    AppMethodBeat.i(181018);
                    if (this.mMapDelegate != null) {
                        this.mMapDelegate.onPause();
                    }
                    AppMethodBeat.o(181018);
                }

                @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView
                public void onRestart() {
                    AppMethodBeat.i(181019);
                    if (this.mMapDelegate != null) {
                        this.mMapDelegate.onRestart();
                    }
                    AppMethodBeat.o(181019);
                }

                @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView
                public void onStop() {
                    AppMethodBeat.i(181020);
                    if (this.mMapDelegate != null) {
                        this.mMapDelegate.onStop();
                    }
                    AppMethodBeat.o(181020);
                }

                @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView
                public void onDestroy() {
                    AppMethodBeat.i(181021);
                    if (this.mMapDelegate != null) {
                        this.mMapDelegate.onDestroy();
                        this.mMapDelegate = null;
                    }
                    this.mMapOptions = null;
                    this.mMap = null;
                    AppMethodBeat.o(181021);
                }

                public void setOnTop(boolean z) {
                    AppMethodBeat.i(181022);
                    if (this.mMapDelegate != null) {
                        this.mMapDelegate.setOnTop(z);
                    }
                    AppMethodBeat.o(181022);
                }

                public void setMapPadding(int i2, int i3, int i4, int i5) {
                    AppMethodBeat.i(181023);
                    setPadding(i2, i3, i4, i5);
                    AppMethodBeat.o(181023);
                }

                public int[] getMapPadding() {
                    AppMethodBeat.i(181024);
                    int[] iArr = {getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom()};
                    AppMethodBeat.o(181024);
                    return iArr;
                }

                public void onSizeChanged(int i2, int i3, int i4, int i5) {
                    AppMethodBeat.i(181025);
                    super.onSizeChanged(i2, i3, i4, i5);
                    if (this.mMapDelegate != null) {
                        this.mMapDelegate.onSizeChanged(i2, i3, i4, i5);
                    }
                    AppMethodBeat.o(181025);
                }

                public void onSurfaceChanged(Object obj, int i2, int i3) {
                    AppMethodBeat.i(181026);
                    if ((obj instanceof Surface) || (obj instanceof SurfaceTexture) || (obj instanceof SurfaceHolder)) {
                        if (this.mMapDelegate != null) {
                            this.mMapDelegate.onSurfaceChanged(obj, i2, i3);
                        }
                        AppMethodBeat.o(181026);
                        return;
                    }
                    AppMethodBeat.o(181026);
                }
            }
