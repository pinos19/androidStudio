package com.example.td5_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {
    List<Contact> contacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        // Lookup the recyclerview in activity layout
        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvContacts);
        // Initialisation des contacts
        contacts.add(new Contact("Jean","Pierre","https://www.moustique.be/wp-content/uploads/2015/06/1129961.jpg"));
        contacts.add(new Contact("Jeanne","D'arc","https://upload.wikimedia.org/wikipedia/commons/7/75/Albert_Lynch_-_Jeanne_d%27Arc.jpg"));
        contacts.add(new Contact("Pierre","Menez","https://upload.wikimedia.org/wikipedia/commons/6/64/Renaud_Beretti_et_Jean-Pierre_Pernaut_%28cropped%29.jpg"));
        contacts.add(new Contact("Arthur","Rimbaud","https://upload.wikimedia.org/wikipedia/commons/1/1c/Rimbaud.PNG"));
        contacts.add(new Contact("Richard","Coeur de lion","https://i2.wp.com/www.histoire-normandie.fr/wp-content/uploads/2016/08/richard_coeur_lion_blondel.jpg"));
        contacts.add(new Contact("Zinedine","Zidane","https://www.topmercato.com/wp-content/uploads/2021/04/Zinedine-Zidane-Real-Madrid.jpg"));
        contacts.add(new Contact("Yannick","Noah","https://www.gala.fr/imgre/fit/http.3A.2F.2Fprd2-bone-image.2Es3-website-eu-west-1.2Eamazonaws.2Ecom.2Fgal.2Fvar.2Fgal.2Fstorage.2Fimages.2Fmedia.2Fimages.2Factu.2Fphotos_on_ne_parle_que_de_ca.2Fyannick_noah11.2F1518687-1-fre-FR.2Fyannick_noah.2Ejpg/480x480/quality/80/yannick-noah-mord-zidane-et-platini.jpg"));
        contacts.add(new Contact("Patrick","Bruel","https://static.cnews.fr/sites/default/files/styles/image_640_360/public/000_9d47xj_61a3a295ecb9c.jpg?itok=dAN_XvFL"));
        contacts.add(new Contact("Dominique","Toretto","https://static.wikia.nocookie.net/fastandfurious/images/7/7a/Dom_Fast_7.jpg/revision/latest/top-crop/width/360/height/450?cb=20150322194951&path-prefix=fr"));
        // Création d'un adapter avec initialisation du constructeur avec notre liste de contacts
        ContactsAdapter adapter = new ContactsAdapter(contacts);
        // On notifie au recyclerview notre adapter
        rvContacts.setAdapter(adapter);
        // On déclare quel type de LayoutManager on désire
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
    }

}