import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {
        Worker john = new Worker(25, 3000, "John");

        Word doc1 = new Word();
        doc1.setModel(new StringFormat(john));

        doc1.setFormat(new XmlFormat());
        doc1.click();

        doc1.setFormat(new MdFormat());
        doc1.click();

        doc1.setFormat(new JsonFormat());
        doc1.click();

        // #region
        // Document doc = new Document();
        // doc.setWorker(new Worker(22, 221, "Какое-то имя"));

        // doc.SaveAs();// Save xml
        // // xml
        // // <xml>
        // // <Worker>
        // // <age>22</age>
        // // <salary>221</salary>
        // // <name>Какое-то имя</name>
        // // </Worker>
        // // </xml>

        // // md
        // doc.SaveAs();// Save md
        // // # Worker
        // // * age 22
        // // * salary 221
        // // * name Какое-то имя

        // // json
        // doc.SaveAs();// Save json
        // // {
        // // "worker" : {
        // // "age":22,
        // // "salary":221,
        // // "name":"Какое-то имя",
        // // }
        // // }
        // #endregion
    }
}

class StringFormat {
    Worker worker;
    StringFormat(Worker worker){
        this.worker = worker;
    }

    public ArrayList<String> getRawData() {
        ArrayList<String> text = new ArrayList<>();
        text.add(String.valueOf(worker.age));
        text.add(String.valueOf(worker.salary));
        text.add(worker.name);
        return text;
    }

}

class Word {
    StringFormat model;

    public void setModel(StringFormat model) {
        this.model = model;
    }

    TitleFormat format;

    public void setFormat(TitleFormat f) {
        format = f;
    }

    void click() {
        format.print(model.getRawData());
    }
}

interface TitleFormat {
    void print(ArrayList<String> worker);
}

class XmlFormat implements TitleFormat {
    @Override
    public void print(ArrayList<String> worker) {
        System.out.println("++++++++++++++ XML format ++++++++++++++");
        System.out.println("<xml>");
        System.out.println("<Worker>");
        System.out.println("<age>" + worker.get(0) + "</age>");
        System.out.println("<salary>" + worker.get(1) + "</salary>");
        System.out.println("<name>" + worker.get(2) + "</name>");
        System.out.println("</Worker>");
        System.out.println("</xml>");
    }
}

class MdFormat implements TitleFormat {
    @Override
    public void print(ArrayList<String> worker) {
        System.out.println("++++++++++++++ MD format ++++++++++++++");
        System.out.println("# Worker");
        System.out.println("* age " + worker.get(0));
        System.out.println("* salary " + worker.get(1));
        System.out.println("* name " + worker.get(2));
    }
}

class JsonFormat implements TitleFormat {
    @Override
    public void print(ArrayList<String> worker) {
        System.out.println("++++++++++++++ Json format ++++++++++++++");
        System.out.println("{");
        System.out.println("\"worker\" : {");
        System.out.println("\"age\":" + worker.get(0));
        System.out.println("\"salary\":" + worker.get(1));
        System.out.println("\"name\":" + worker.get(2));
        System.out.println("}");
        System.out.println("}");
    }
}

class Worker {
    int age;
    int salary;
    String name;
    Worker(int age, int salary, String name){
        this.age = age;
        this.salary = salary;
        this.name = name;
    }
}
