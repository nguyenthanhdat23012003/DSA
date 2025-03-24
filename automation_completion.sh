# Enable auto-completion for the tool.sh script

_automation_completion() {
    # Define the main commands for the script
    local commands="addMethod pushMethods pushDefinition addProblem pushProblems addStructure pushStructures"
    
    # Define difficulty levels for the addProblem function
    local difficulties="easy medium hard"

    # Check if the current word being typed is the first argument
    if [ $COMP_CWORD -eq 1 ]; then
        # Provide suggestions for main commands when typing the first argument
        COMPREPLY=($(compgen -W "$commands" -- "${COMP_WORDS[1]}"))
    elif [ $COMP_CWORD -eq 2 ] && [[ "${COMP_WORDS[1]}" == "addProblem" ]]; then
        # Provide suggestions for difficulty levels when the first command is "addProblem"
        COMPREPLY=($(compgen -W "$difficulties" -- "${COMP_WORDS[2]}"))
    else
        # Clear suggestions for other cases
        COMPREPLY=()
    fi
}

# Register _automation_completion function to complete ./tool.sh commands
complete -F _automation_completion ./tool.sh
