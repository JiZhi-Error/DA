package com.tencent.mm.plugin.topstory.ui.video.list;

import android.graphics.PointF;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ae;
import android.support.v7.widget.aj;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.a;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.widget.f;
import com.tencent.mm.sdk.platformtools.Log;

public final class c extends f {
    b GlS;
    private aj aqX;
    private aj aqY;

    public c(b bVar) {
        this.GlS = bVar;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.widget.f
    public final int[] a(RecyclerView.LayoutManager layoutManager, View view) {
        AppMethodBeat.i(126409);
        int[] iArr = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            iArr[0] = b(view, c(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.canScrollVertically()) {
            iArr[1] = b(view, b(layoutManager));
        } else {
            iArr[1] = 0;
        }
        AppMethodBeat.o(126409);
        return iArr;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.widget.f
    public final View a(RecyclerView.LayoutManager layoutManager) {
        AppMethodBeat.i(126410);
        if (layoutManager.canScrollVertically()) {
            View a2 = a(layoutManager, b(layoutManager));
            AppMethodBeat.o(126410);
            return a2;
        } else if (layoutManager.canScrollHorizontally()) {
            View a3 = a(layoutManager, c(layoutManager));
            AppMethodBeat.o(126410);
            return a3;
        } else {
            AppMethodBeat.o(126410);
            return null;
        }
    }

    @Override // com.tencent.mm.plugin.topstory.ui.widget.f
    public final int a(RecyclerView.LayoutManager layoutManager, int i2, int i3) {
        boolean z;
        boolean z2;
        PointF bZ;
        int i4 = -1;
        AppMethodBeat.i(126411);
        if (Math.abs(i3) <= 500 || Math.abs(i2) >= Math.abs(i3)) {
            AppMethodBeat.o(126411);
        } else {
            int itemCount = layoutManager.getItemCount();
            if (itemCount == 0) {
                AppMethodBeat.o(126411);
            } else {
                int fyH = this.GlS.fyH() + 1;
                if (fyH == -1) {
                    AppMethodBeat.o(126411);
                } else {
                    if (layoutManager.canScrollHorizontally()) {
                        z = i2 > 0;
                    } else {
                        z = i3 > 0;
                    }
                    if (!(layoutManager instanceof RecyclerView.r.b) || (bZ = ((RecyclerView.r.b) layoutManager).bZ(itemCount - 1)) == null) {
                        z2 = false;
                    } else if (bZ.x < 0.0f || bZ.y < 0.0f) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        if (!z) {
                            i4 = fyH + 1;
                        }
                        i4 = fyH - 1;
                    } else {
                        if (z) {
                            i4 = fyH + 1;
                        }
                        i4 = fyH - 1;
                    }
                    Log.i("MicroMsg.TopStory.TopStoryVideoPagerSnapHelper", "findTargetSnapPosition velocityY: %d centerPosition: %d forwardDirection: %b result: %d currentPlayPos: %d", Integer.valueOf(i3), Integer.valueOf(fyH), Boolean.valueOf(z), Integer.valueOf(i4), Integer.valueOf(this.GlS.fyH() + 1));
                    AppMethodBeat.o(126411);
                }
            }
        }
        return i4;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.widget.f
    public final ae f(RecyclerView.LayoutManager layoutManager) {
        AppMethodBeat.i(126412);
        if (!(layoutManager instanceof RecyclerView.r.b)) {
            AppMethodBeat.o(126412);
            return null;
        }
        AnonymousClass1 r0 = new ae(this.mRecyclerView.getContext()) {
            /* class com.tencent.mm.plugin.topstory.ui.video.list.c.AnonymousClass1 */

            @Override // android.support.v7.widget.ae, android.support.v7.widget.RecyclerView.r
            public final void a(View view, RecyclerView.s sVar, RecyclerView.r.a aVar) {
                AppMethodBeat.i(126407);
                int[] a2 = c.this.a(c.this.mRecyclerView.getLayoutManager(), view);
                int i2 = a2[0];
                int i3 = a2[1];
                int cc = cc(Math.max(Math.abs(i2), Math.abs(i3)));
                if (cc > 0) {
                    aVar.a(i2, i3, cc, this.VQ);
                }
                AppMethodBeat.o(126407);
            }

            @Override // android.support.v7.widget.ae
            public final float a(DisplayMetrics displayMetrics) {
                return 100.0f / ((float) displayMetrics.densityDpi);
            }

            @Override // android.support.v7.widget.ae
            public final int cd(int i2) {
                AppMethodBeat.i(126408);
                int min = Math.min(100, super.cd(i2));
                AppMethodBeat.o(126408);
                return min;
            }
        };
        AppMethodBeat.o(126412);
        return r0;
    }

    private int b(View view, aj ajVar) {
        AppMethodBeat.i(126413);
        int bo = ajVar.bo(view) - this.GlS.fyN();
        AppMethodBeat.o(126413);
        return bo;
    }

    private static View a(RecyclerView.LayoutManager layoutManager, aj ajVar) {
        int end;
        View view = null;
        AppMethodBeat.i(126414);
        int childCount = layoutManager.getChildCount();
        if (childCount == 0) {
            AppMethodBeat.o(126414);
        } else {
            if (layoutManager.getClipToPadding()) {
                end = ajVar.kH() + ((ajVar.kJ() - a.GjN) / 2);
            } else {
                end = ajVar.getEnd() / 2;
            }
            int i2 = Integer.MAX_VALUE;
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = layoutManager.getChildAt(i3);
                int abs = Math.abs((ajVar.bo(childAt) + (ajVar.bs(childAt) / 2)) - end);
                if (abs >= i2) {
                    abs = i2;
                    childAt = view;
                }
                i3++;
                i2 = abs;
                view = childAt;
            }
            AppMethodBeat.o(126414);
        }
        return view;
    }

    private aj b(RecyclerView.LayoutManager layoutManager) {
        AppMethodBeat.i(126415);
        if (this.aqX == null || this.aqX.getLayoutManager() != layoutManager) {
            this.aqX = aj.e(layoutManager);
        }
        aj ajVar = this.aqX;
        AppMethodBeat.o(126415);
        return ajVar;
    }

    private aj c(RecyclerView.LayoutManager layoutManager) {
        AppMethodBeat.i(126416);
        if (this.aqY == null || this.aqY.getLayoutManager() != layoutManager) {
            this.aqY = aj.d(layoutManager);
        }
        aj ajVar = this.aqY;
        AppMethodBeat.o(126416);
        return ajVar;
    }
}
