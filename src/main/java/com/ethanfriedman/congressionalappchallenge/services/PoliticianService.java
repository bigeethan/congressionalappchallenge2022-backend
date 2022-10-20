package com.ethanfriedman.congressionalappchallenge.services;


import com.ethanfriedman.congressionalappchallenge.models.Governors;
import com.ethanfriedman.congressionalappchallenge.models.Presidents;
import com.ethanfriedman.congressionalappchallenge.models.Senators;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class PoliticianService {
    private static final String COLLECTION_NAME1 = "governors";
    private static final String COLLECTION_NAME2 = "presidents";
    private static final String COLLECTION_NAME3 = "senators";

    //save governor to Firebase
    public String saveGovernor(Governors governors) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();

        dbFirestore.collection(COLLECTION_NAME1).document(governors.getName()).set(governors);

        return "Governor Added Successfully";
    }

    //get governor from Firebase
    public Governors getGovernor(String name) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();

        DocumentReference collectionReference = dbFirestore.collection(COLLECTION_NAME1).document(name);

        ApiFuture<DocumentSnapshot> apiDocReference = collectionReference.get();

        DocumentSnapshot documentSnap = apiDocReference.get();

        Governors governor = null;

        if (documentSnap.exists()) {
            governor = documentSnap.toObject(Governors.class);
            return governor;
        } else {
            return null;
        }
    }

    //save president to Firebase
    public String savePresident(Presidents presidents) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();

        dbFirestore.collection(COLLECTION_NAME2).document(presidents.getName()).set(presidents);

        return "President Added Successfully";
    }

    //get president from Firebase
    public Presidents getPresident(String name) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();

        DocumentReference collectionReference = dbFirestore.collection(COLLECTION_NAME2).document(name);

        ApiFuture<DocumentSnapshot> apiDocReference = collectionReference.get();

        DocumentSnapshot documentSnap = apiDocReference.get();

        Presidents presidents = null;

        if (documentSnap.exists()) {
            presidents = documentSnap.toObject(Presidents.class);
            return presidents;
        } else {
            return null;
        }
    }

    //save senator to Firebase
    public String saveSenator(Senators senators) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();

        dbFirestore.collection(COLLECTION_NAME3).document(senators.getName()).set(senators);

        return "Senator Added Successfully";
    }

    //get senator from Firebase
    public Senators getSenator(String name) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();

        DocumentReference collectionReference = dbFirestore.collection(COLLECTION_NAME3).document(name);

        ApiFuture<DocumentSnapshot> apiDocReference = collectionReference.get();

        DocumentSnapshot documentSnap = apiDocReference.get();

        Senators senators = null;

        if (documentSnap.exists()) {
            senators = documentSnap.toObject(Senators.class);
            return senators;
        } else {
            return null;
        }
    }
}
