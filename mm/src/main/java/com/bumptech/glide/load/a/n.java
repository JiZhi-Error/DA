package com.bumptech.glide.load.a;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileNotFoundException;
import java.io.InputStream;

public final class n extends l<InputStream> {
    private static final UriMatcher aFq;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.a.l
    public final /* synthetic */ void R(InputStream inputStream) {
        AppMethodBeat.i(76900);
        inputStream.close();
        AppMethodBeat.o(76900);
    }

    static {
        AppMethodBeat.i(76902);
        UriMatcher uriMatcher = new UriMatcher(-1);
        aFq = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        aFq.addURI("com.android.contacts", "contacts/lookup/*", 1);
        aFq.addURI("com.android.contacts", "contacts/#/photo", 2);
        aFq.addURI("com.android.contacts", "contacts/#", 3);
        aFq.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        aFq.addURI("com.android.contacts", "phone_lookup/*", 5);
        AppMethodBeat.o(76902);
    }

    public n(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    @Override // com.bumptech.glide.load.a.d
    public final Class<InputStream> os() {
        return InputStream.class;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.a.l
    public final /* synthetic */ InputStream a(Uri uri, ContentResolver contentResolver) {
        InputStream openContactPhotoInputStream;
        AppMethodBeat.i(76901);
        switch (aFq.match(uri)) {
            case 1:
            case 5:
                Uri lookupContact = ContactsContract.Contacts.lookupContact(contentResolver, uri);
                if (lookupContact != null) {
                    openContactPhotoInputStream = ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, lookupContact, true);
                    break;
                } else {
                    FileNotFoundException fileNotFoundException = new FileNotFoundException("Contact cannot be found");
                    AppMethodBeat.o(76901);
                    throw fileNotFoundException;
                }
            case 2:
            case 4:
            default:
                openContactPhotoInputStream = contentResolver.openInputStream(uri);
                break;
            case 3:
                openContactPhotoInputStream = ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
                break;
        }
        if (openContactPhotoInputStream == null) {
            FileNotFoundException fileNotFoundException2 = new FileNotFoundException("InputStream is null for ".concat(String.valueOf(uri)));
            AppMethodBeat.o(76901);
            throw fileNotFoundException2;
        }
        AppMethodBeat.o(76901);
        return openContactPhotoInputStream;
    }
}
