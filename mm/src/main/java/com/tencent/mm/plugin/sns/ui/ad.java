package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cjy;
import java.util.LinkedList;
import java.util.List;
import org.b.d.i;

public interface ad {
    boolean a(int i2, int i3, i iVar, String str, List<String> list, cjy cjy, LinkedList<Long> linkedList, int i4, boolean z, List<String> list2, PInt pInt, String str2, int i5, int i6);

    void aC(Bundle bundle);

    void aD(Bundle bundle);

    boolean ffA();

    View ffB();

    boolean ffC();

    boolean ffD();

    boolean ffE();

    boolean k(int i2, Intent intent);
}
