package report6;
// 단어를 넣을 Word 클래스를 만들기
// 벡터에 word 클래스를 넣기

import java.util.Vector;

class Word{
	String kor, eng;
	
	public Word(String kor, String eng) {
		this.kor = kor;
		this.eng = eng;
	}
	
}

public class challenge {
	public static void main(String[] args) {
		Vector<Word> v = new Vector<Word>();
		v.add(new Word("love", "사랑"));
		v.add(new Word("emotion", "감정"));
		v.add(new Word("baby", "아기"));
		v.add(new Word("picture", "그림"));
		v.add(new Word("error", "오류"));
		v.add(new Word("society", "사회"));
		v.add(new Word("doll", "인형"));
		v.add(new Word("bear", "곰"));
		v.add(new Word("eye", "눈"));
		v.add(new Word("human", "인간"));
		v.add(new Word("statue", "조각상"));
		v.add(new Word("animal", "동물"));
		v.add(new Word("deal", "거래"));
	}
}