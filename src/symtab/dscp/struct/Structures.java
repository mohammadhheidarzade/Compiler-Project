package symtab.dscp.struct;

import ast.type.Type;
import symtab.dscp.AbstractDescriptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Structures {

    private static final Structures instance = new Structures();

    final List<StructureDescriptor> ALL_STRUCTURE_TYPES = new ArrayList<>();

    private Structures() {
    }

    public static Structures getInstance() {
        return instance;
    }

    public boolean typeExists(String typeName) {
        List<String> types = ALL_STRUCTURE_TYPES.stream().map(AbstractDescriptor::getType).map(Type::typeName).collect(Collectors.toList());
        for (String type : types)
            if (type.equals(typeName))
                return true;
        return false;
    }

    public void addStructure(StructureDescriptor descriptor) {
        ALL_STRUCTURE_TYPES.add(descriptor);
    }

    public StructureDescriptor newDescriptor(Type type) {
        System.out.println("here");
        return Objects.requireNonNull(ALL_STRUCTURE_TYPES.stream().filter(d -> d.getType().equals(type)).findFirst().orElse(null)).clone();
    }

}
