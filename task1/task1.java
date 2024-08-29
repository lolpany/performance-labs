class task1 {

    public static void main(String[] args) {
        int size = Integer.parseInt(args[0]);
        int interval = Integer.parseInt(args[1]) - 1;
        String result = "";
        int position = 1;
        do {
            result += position;
            position = (position + interval) % size;
            if (position == 0) {
                position = size;
            }
        } while (position != 1);
        System.out.println(result);
    }

}