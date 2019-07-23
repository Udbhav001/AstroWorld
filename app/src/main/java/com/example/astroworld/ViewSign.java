package com.example.astroworld;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class ViewSign extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.viewsign,container,false);
        ImageView t=v.findViewById(R.id.zodiacsign);

        TextView tv=v.findViewById(R.id.zodiactext);

             if(HomePage1.sign.equals("ARIES"))
        {
            Picasso.get().load("https://thumbs.dreamstime.com/z/zodiac-sign-aries-made-stars-use-vector-illustration-design-your-website-publications-71559300.jpg").into(t);
            tv.setText("Aries: Zodiac Sign Traits\n" +
                    "Upbeat and ready for anything, Aries is the first sign of the zodiac -- the pioneer and the initiator! Ruled by Fire, the Ram lives in the moment and moves fast and furiously. They're natural-born leaders, and impossible to ignore! They are always ready to take charge and conquer whatever challenge they meet. Courageous and competitive, Aries is a powerful force, carving paths through new territory to find undiscovered treasures. This fearless sign lives life as a warrior, infusing everything it touches with fire, passion, and strength.\n" +
                    "\n");
        }
        if(HomePage1.sign.equals("PISCES"))
        {
            Picasso.get().load("https://cdn4.vectorstock.com/i/1000x1000/91/83/zodiac-sign-of-pisces-made-of-stars-vector-9819183.jpg").into(t);
            tv.setText("Pisces: Zodiac Sign Traits\n" +
                    "Dreamy, sensitive, and spiritual Pisces is drawn to all things mystical! The emotional Fishes are filled with so much compassion and empathy, they often put others’ needs before their own. Ruled by Neptune, Pisces is intuitive and incredibly creative by nature. With a soul as deep and vast as the oceans, Pisces thrives in a world of fantasy, where its imagination can flow freely. Driven by its strong connection to the spiritual world, the sign of the Fishes knows how to balance cold, hard reality with the warmth of love and understanding.");
        }if(HomePage1.sign.equals("VIRGO"))
        {
            Picasso.get().load("https://cdn5.vectorstock.com/i/thumb-large/91/94/zodiac-sign-of-virgo-made-of-stars-vector-9819194.jpg").into(t);
            tv.setText("Virgo: Zodiac Sign Traits\n" +
                    "Perfection comes in the form of Virgo, the sixth sign of the zodiac. This hardworking, detail-oriented, and critical sign is represented by the Virgin for its pure and discriminating nature. Observant Virgo is quick to notice flaws and fix them, helping others reach their highest potential. One of Virgo’s strongest abilities is to take in a wealth of information, and pick out only what’s important and useful. This makes Virgo one of the most productive and efficient signs of all.");
        }if(HomePage1.sign.equals("GEMINI"))
        {
            Picasso.get().load("https://cdn5.vectorstock.com/i/thumb-large/91/64/zodiac-sign-of-gemini-made-of-stars-vector-9819164.jpg").into(t);
            tv.setText("Gemini: Zodiac Sign Traits\n" +
                    "Here come the Gemini Twins, going a mile a minute! Clever and curious Gemini is a sign that thinks fast, communicates well, and is full of ideas. Their versatility and adaptability stem from their split personality -- part intellect, part scatterbrained! The Twins are powered by information and feel most at home when sharing thoughts and conversations with others. Gemini is like a sponge, soaking up as much information as they possibly can. Whether it’s through reading, talking, or writing, Gemini’s thirst for knowledge is constant. As the most talkative sign of the zodiac, the Twins are known to be social, and are always on the lookout for a good time. Thriving on variety, you never know what you’ll get with Gemini!\n" +
                    "\n");
        }if(HomePage1.sign.equals("ACQUARIUS"))
        {
            Picasso.get().load("https://cdn3.vectorstock.com/i/1000x1000/91/47/zodiac-sign-of-aquarius-made-of-stars-vector-9819147.jpghttps://cdn3.vectorstock.com/i/1000x1000/91/47/zodiac-sign-of-aquarius-made-of-stars-vector-9819147.jpghttps://cdn3.vectorstock.com/i/1000x1000/91/47/zodiac-sign-of-aquarius-made-of-stars-vector-9819147.jpghttps://cdn3.vectorstock.com/i/1000x1000/91/47/zodiac-sign-of-aquarius-made-of-stars-vector-9819147.jpg").into(t);
            tv.setText("Aquarius: Zodiac Sign Traits\n" +
                    "Quirky Aquarius marches to the beat of its own drum! The Water-bearer is actually an Air sign whose dual nature creates a unique, intellectual, and social individual who cares deeply for community and mankind. While Aquarius prefers ideas over emotions, their stimulating personality earns them fast friends. The worldly Water-bearer is a progressive spirit who’s focused on the greater good. When this rebellious sign isn’t satisfied with the way things are, they’re experts at garnering the support they need to instigate change. Ruled more by the head than the heart, Aquarius’ brilliant ideas and visionary plans inspire us all to raise the bar in our everyday lives.");
        }if(HomePage1.sign.equals("SCORPIO"))
        {
            Picasso.get().load("https://st2.depositphotos.com/2417289/10926/v/950/depositphotos_109267694-stock-illustration-zodiac-sign-of-scorpio-made.jpg").into(t);
            tv.setText("Scorpio: Zodiac Sign Traits\n" +
                    "Deep and passionate Scorpio is a mystery to most! This sign is directly associated with the underworld, so they’re right at home in the darkest of places. But it’s not about dwelling here forever. Scorpio the Scorpion is all about transformation, and their ultimate goal is to bring all that’s hidden into the light. Scorpio thrives in a world of passion, depth, questions, and answers. The Scorpion isn’t interested in what’s sitting right on the surface -- they want to dig down to get to the real treasures that lie beneath. Intense and steadfast, this sign’s lifelong mission is to rebuild itself over and over again, creating, in the end, the most aware, insightful, and capable soul imaginable.");
        }if(HomePage1.sign.equals("CAPRICORN"))
        {
            Picasso.get().load("https://cdn3.vectorstock.com/i/thumb-large/91/62/zodiac-sign-of-capricorn-made-of-stars-vector-9819162.jpg").into(t);
            tv.setText("Capricorn: Zodiac Sign Traits\n" +
                    "Slow and steady, cool and calculating, Capricorn is a hard-working and successful force to be reckoned with! The Mountain Goat has a destination in mind and will stop at nothing to reach its goal. They combine their traditional methods with powerful determination to climb the ladder of success each and every day. Caring, conservative Capricorn is a great leader and a dedicated provider. They like to play hard, and work harder.\n" +
                    "\n");
        }if(HomePage1.sign.equals("LIBRA"))
        {
            Picasso.get().load("https://cdn1.vectorstock.com/i/1000x1000/91/80/zodiac-sign-of-libra-made-of-stars-vector-9819180.jpg").into(t);
            tv.setText("Libra: Zodiac Sign Traits\n" +
                    "Gracious, fair, and balanced Libra is among the most social and popular signs of the zodiac! Ruled by Venus, Libra is a loving sign that focuses strongly on partnership and prioritizes the needs of others. This sign of the Scales is blessed with a natural sense of right and wrong, making them very focused on justice, honesty, and fairness. As the sign of balance, Libra represents both the head and the heart -- they focus on logic and fact to ensure everything is on the up-and-up, but really thrive in the mutual feelings and closeness of one-on-one relationships. Beautiful both inside and out, Libra stands for harmony, elegance, and equality.");
        }if(HomePage1.sign.equals("SAGITTARIUS"))
        {
            Picasso.get().load("https://cdn5.vectorstock.com/i/1000x1000/91/84/zodiac-sign-of-sagittarius-made-of-stars-vector-9819184.jpg").into(t);
            tv.setText("Sagittarius: Zodiac Sign Traits\n" +
                    "Adventurous, optimistic, and lucky Sagittarius aims high and shoots for the stars! Ruled by Jupiter, the planet of growth and opportunity, the sign of the Archer is an eternal student, looking for enlightenment through new ideas, people, and places. Sagittarius is on the hunt for the biggest, best experiences life has to offer! They have a positive and outgoing personality that makes them the life of any party. With a love of adventure and all things exotic, the worldly Archer just wants to soak it all in. Sagittarius is driven by a constant need to explore and expand its mind, heart, and awareness to the fullest extent. Fiery and free, Sagittarius knows that the only limits are the ones we create ourselves.");
        }if(HomePage1.sign.equals("CANCER"))
        {
            Picasso.get().load("https://cdn1.vectorstock.com/i/1000x1000/91/60/zodiac-sign-of-cancer-made-of-stars-vector-9819160.jpg").into(t);
            tv.setText("Cancer: Zodiac Sign Traits\n" +
                    "Tough on the outside but soft on the inside, Cancer the Crab is a sensitive sign that cares deeply about others. Tenaciously loyal and loving, Cancers are the nurturers of the zodiac, and will fiercely protect themselves and anything they hold dear. They are lovers not fighters, but will always fight for who they love. Embodied by the Crab’s hard shell, Cancer prizes comfort, security, and protection. This sign is connected to the grace and ferocity of motherhood, making them both emotional and intuitive, and highly influenced by subconscious thought and feeling.");
        }if(HomePage1.sign.equals("TAURUS"))
        {
            Picasso.get().load("https://cdn2.vectorstock.com/i/1000x1000/91/91/zodiac-sign-of-taurus-made-of-stars-vector-9819191.jpg").into(t);
            tv.setText("Taurus: Zodiac Sign Traits\n" +
                    "Successful, sensual, and sensible, Taurus the Bull wants to indulge in anything it can touch, smell, and taste! Taurus knows how to slow down and appreciate the finer things in life. The stable Bull is both patient and determined, leading a life that’s balanced with hard work and great reward. Taurus is also known for being stubborn, but it's not about standing in the way -- Taurus' stubbornness comes through in its sense of determination. Refusing to give up, Taurus will push through to the end, no matter what tries to block its path. Careful and low-risk, the Bull knows that slow and steady wins the race");
        }if(HomePage1.sign.equals("LEO"))
        {
            Picasso.get().load("https://cdn4.vectorstock.com/i/thumb-large/91/68/zodiac-sign-of-leo-made-of-stars-vector-9819168.jpg").into(t);
            tv.setText("Leo: Zodiac Sign Traits\n" +
                    "Fun and flirtatious Leo heats things up as the most expressive sign of the zodiac! Ruled by the vibrant Sun and driven by the warmth of its Fire element, the charming, magnificent, and dramatic Lion is the life of the party and loves attention. With its shining heart of gold, Leo is a loyal lover and a proud and courageous leader. This sign of the Lion embodies an air of royalty, just like the kings and queens of the jungle. Sometimes expressive to a fault, Leo has never been known to keep its feelings hidden! Steer clear of Leo’s drama, and you’ll find some of the most generous souls you’ll ever meet.\n" +
                    "\n");
        }
        return v;
    }
}
