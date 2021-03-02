package com.google.android.flexbox;

import android.view.View;
import java.util.List;

interface a {
    void a(int i2, View view);

    void a(View view, int i2, int i3, b bVar);

    void a(b bVar);

    int bV(View view);

    View fj(int i2);

    View fk(int i2);

    int getAlignContent();

    int getAlignItems();

    int getFlexDirection();

    int getFlexItemCount();

    List<b> getFlexLinesInternal();

    int getFlexWrap();

    int getLargestMainSize();

    int getMaxLine();

    int getPaddingBottom();

    int getPaddingEnd();

    int getPaddingLeft();

    int getPaddingRight();

    int getPaddingStart();

    int getPaddingTop();

    int getSumOfCrossSize();

    int m(View view, int i2, int i3);

    void setFlexLines(List<b> list);

    int t(int i2, int i3, int i4);

    int u(int i2, int i3, int i4);

    boolean xC();
}
