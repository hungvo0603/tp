package seedu.duke.filters;

import seedu.duke.exceptions.FilterCommandException;

import java.util.ArrayList;

public class FilterCommandSlicer {

    public static boolean continueLastFilter (String command) {
        return !command.toLowerCase().contains(" -continue");
    }

    public static FilterType getTypeOfFilter (String command) throws FilterCommandException {
        if (!command.toLowerCase().contains("by\\")) {
            throw new FilterCommandException();
        }

        int indexOfTypeTag = command.indexOf("by\\");
        String cutCommand = command.substring(indexOfTypeTag);
        cutCommand = cutCommand.replace("by\\", "");
        FilterType filterType;
        if (cutCommand.toLowerCase().trim().startsWith("type")) {
            filterType = FilterType.WORD_TYPE;
        } else if (cutCommand.toLowerCase().trim().startsWith("start")) {
            filterType = FilterType.STARTING_STRING;
        } else if (cutCommand.toLowerCase().trim().startsWith("include")) {
            filterType = FilterType.CONTAINING_STRING;
        } else {
            throw new FilterCommandException();
        }

        return filterType;
    }

    public static String[] getTargetedWordType (String command) throws FilterCommandException {
        ArrayList<String> types = new ArrayList<>();
        if (command.toLowerCase().contains(" -noun")) {
            types.add("noun");
        }
        if (command.toLowerCase().contains(" -verb")) {
            types.add("verb");
        }
        if (command.toLowerCase().contains(" -adjective")) {
            types.add("adjective");
        }

        if (types.size() == 0) {
            throw new FilterCommandException();
        }
        return types.toArray(new String[0]);
    }

    public static String[] getTargetedStringTags(String command) throws FilterCommandException {
        ArrayList<String> targetedStrings = new ArrayList<>();
        int index = command.indexOf("-");
        while (index >= 0) {
            int nextIndex = command.indexOf("-", index + 1);
            if (nextIndex != -1) {
                targetedStrings.add(command.substring(index + 1, nextIndex).trim());
            } else {
                targetedStrings.add(command.substring(index + 1));
            }
            index = command.indexOf("-", index + 1);
        }

        if (targetedStrings.size() == 0) {
            throw new FilterCommandException();
        }
        return targetedStrings.toArray(new String[0]);
    }

}
