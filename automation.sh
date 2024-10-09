#!/bin/bash

# Directory for methods, definitions, and data structures
METHOD_DIR="background_theory/method"
DEFINITION_FILE="background_theory/definition.md"
DATA_STRUCTURE_DIR="background_theory/data_structure"
PROBLEM_DIR="problem"

# Files to track existing methods, problems, and data structures
METHODS_FILE="methods.txt"
PROBLEMS_FILE="problems.txt"
STRUCTURES_FILE="structures.txt"

# Function to add a new method
addMethod() {
    method_name="$1"
    
    # Check if method already exists
    if grep -Fxq "$method_name" "$METHODS_FILE"; then
        echo "Method '$method_name' already exists."
        return
    fi

    # Replace spaces with underscores and create file name
    method_file_name=$(echo "$method_name" | sed 's/ /_/g').md
    method_path="$METHOD_DIR/$method_file_name"

    # Create the .md file for the method
    touch "$method_path"
    echo "Created method $method_name with path: $method_path"
}

# Function to push all methods to Git
pushMethods() {
    for method_file in "$METHOD_DIR"/*.md; do
        if [ -f "$method_file" ]; then
            method_name=$(basename "$method_file" .md | sed 's/_/ /g')
            if ! grep -Fxq "$method_name" "$METHODS_FILE"; then
                git add "$method_file"
                echo "$method_name" >> "$METHODS_FILE"  # Log the new method
                git add "$METHODS_FILE"
                git commit -m "Theory: $method_name"
                echo "Pushed method changes to Git: $method_name"
            fi
        fi
    done
    git push origin master
}

# Function to push definition to Git
pushDefinition() {
    git add "$DEFINITION_FILE"
    git commit -m "Theory: Add definition"
    git push origin master
    echo "Definition changes pushed to Git."
}

# Function to add a new problem
addProblem() {
    difficulty="$1"
    problem_name="$2"

    # Check if problem already exists
    if grep -Fxq "$problem_name" "$PROBLEMS_FILE"; then
        echo "Problem '$problem_name' already exists."
        return
    fi

    # Create path and folder name for the problem
    problem_folder=$(echo "$problem_name" | sed 's/ /_/g')
    problem_path="$PROBLEM_DIR/$difficulty/$problem_folder"
    
    # Create folder for the problem and required files
    mkdir -p "$problem_path"
    touch "$problem_path/problem.txt"
    touch "$problem_path/Solution.java"
    
    # Add line to the Solution.java file
    echo "package problem.$difficulty.$problem_folder;" > "$problem_path/Solution.java"
    echo "Created problem $problem_name with folder: $problem_path"
}

# Function to push all problems to Git
pushProblems() {
    for difficulty in easy medium hard; do
        for problem_folder in "$PROBLEM_DIR/$difficulty"/*; do
            if [ -d "$problem_folder" ]; then
                problem_name=$(basename "$problem_folder" | sed 's/_/ /g')
                if ! grep -Fxq "$problem_name" "$PROBLEMS_FILE"; then
                    git add "$problem_folder"
                    echo "$problem_name" >> "$PROBLEMS_FILE"  # Log the new problem
                    git add "$PROBLEMS_FILE"
                    git commit -m "Problem: $problem_name"
                    echo "Pushed problem changes to Git: $problem_name"
                fi
            fi
        done
    done
    git push origin master
}

# Function to add a new data structure
addStructure() {
    structure_name="$1"

    # Check if data structure already exists
    if grep -Fxq "$structure_name" "$STRUCTURES_FILE"; then
        echo "Data structure '$structure_name' already exists."
        return
    fi

    # Replace spaces with underscores and create file name
    structure_file_name=$(echo "$structure_name" | sed 's/ /_/g').md
    structure_path="$DATA_STRUCTURE_DIR/$structure_file_name"

    # Create the .md file for the data structure
    touch "$structure_path"
    echo "Created data structure $structure_name with path: $structure_path"
}

# Function to push all data structures to Git
pushStructures() {
    for structure_file in "$DATA_STRUCTURE_DIR"/*.md; do
        if [ -f "$structure_file" ]; then
            structure_name=$(basename "$structure_file" .md | sed 's/_/ /g')
            if ! grep -Fxq "$structure_name" "$STRUCTURES_FILE"; then
                git add "$structure_file"
                echo "$structure_name" >> "$STRUCTURES_FILE"  # Log the new data structure
                git add "$STRUCTURES_FILE"
                git commit -m "Data Structure: $structure_name"
                echo "Pushed data structure changes to Git: $structure_name"
            fi
        fi
    done
    git push origin master
}

# Check parameters and call corresponding function
case "$1" in
    addMethod)
        if [ -z "$2" ]; then
            echo "Usage: ./automation.sh addMethod \"Method Name\""
        else
            addMethod "$2"
        fi
        ;;
    pushMethods)
        pushMethods
        ;;
    pushDefinition)
        pushDefinition
        ;;
    addProblem)
        if [ -z "$2" ] || [ -z "$3" ]; then
            echo "Usage: ./automation.sh addProblem {easy|medium|hard} \"Problem Name\""
        else
            addProblem "$2" "$3"
        fi
        ;;
    pushProblems)
        pushProblems
        ;;
    addStructure)
        if [ -z "$2" ]; then
            echo "Usage: ./automation.sh addStructure \"Structure Name\""
        else
            addStructure "$2"
        fi
        ;;
    pushStructures)
        pushStructures
        ;;
    *)
        echo "Usage: ./automation.sh {addMethod|pushMethods|pushDefinition|addProblem|pushProblems|addStructure|pushStructures}"
        ;;
esac
