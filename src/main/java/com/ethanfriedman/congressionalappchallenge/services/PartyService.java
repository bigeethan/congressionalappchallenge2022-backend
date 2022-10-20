package com.ethanfriedman.congressionalappchallenge.services;

import com.ethanfriedman.congressionalappchallenge.models.Parties;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class PartyService {
    private static final String COLLECTION_NAME = "parties";

    //save party to Firebase
    public String saveParty(Parties parties) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();

        dbFirestore.collection(COLLECTION_NAME).document(parties.getName()).set(parties);

        return "Party Added Successfully";
    }

    //get party from Firebase
    public Parties getParty(String name) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();

        DocumentReference documentReference = dbFirestore.collection(COLLECTION_NAME).document(name);

        ApiFuture<DocumentSnapshot> apiDocReference = documentReference.get();

        DocumentSnapshot documentSnapshot = apiDocReference.get();

        Parties parties = null;

        if (documentSnapshot.exists()) {
            parties = documentSnapshot.toObject(Parties.class);
            return parties;
        } else {
            return null;
        }
    }
}
