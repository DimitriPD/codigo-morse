public class Node {
    private String letter;
    private String sequence;
    private Node leftNode;
    private Node rightNode;

    public Node(String sequence, String letter) {
        this.letter = letter;
        this.sequence = sequence;
        this.leftNode = null;
        this.rightNode = null;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String value) {
        this.letter = value;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }
}
