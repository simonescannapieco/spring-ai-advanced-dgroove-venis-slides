# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview
This is a LaTeX-based presentation repository for an advanced Spring AI course delivered to Venis S.p.A. The repository contains slides for both theoretical concepts and practical exercises related to Spring AI and generative artificial intelligence with Java.

## Repository Structure
- `/theory/` - Theoretical presentation slides (RAG, fine-tuning, MCP, multimodality)
- `/practice/` - Practical exercise slides numbered 18-31 covering various Spring AI implementations
- `/material/` - Course materials and reference documents
- `/img/` - Global images and assets used across presentations
- `base.tex` - Main LaTeX theme configuration using the Moloch theme with Venis branding
- `initialize_*.tex` - LaTeX initialization files for different presentation formats

## Build System
Each presentation directory (both theory and practice) contains:
- `main.tex` - Standard presentation slides
- `main_handout.tex` - Handout version of slides
- `main_handout_notes.tex` - Handout with speaker notes
- `compile_slides.sh` - Build script for generating PDFs
- `/out/` - Output directory for compiled PDFs

### Building Presentations
To compile slides in any presentation directory:
```bash
cd practice/[lesson_name] # or theory/[lesson_name]
./compile_slides.sh
```

The build script:
1. Cleans the output directory
2. Runs xelatex twice for each format (resolves references)
3. Generates three PDFs with descriptive names based on directory

### Manual Compilation
For individual builds:
```bash
xelatex -shell-escape -synctex=1 -interaction=nonstopmode -output-directory=out main.tex
```

## LaTeX Configuration
- Uses XeLaTeX compiler (required for -shell-escape and font support)
- Moloch theme with custom Venis branding colors
- Minted package for syntax highlighting (requires shell-escape)
- Italian language support via babel package
- Custom codeblock environment for code presentations

## Content Organization
Theory modules (6-9):
- Fine tuning
- RAG (Retrieval-Augmented Generation)
- MCP (Model Control Protocol)
- Multimodality

Practice modules (18-31):
- Advanced prompting techniques (step-back, chain-of-thought, etc.)
- Ollama integration and configuration
- Docker model runners
- Chat memory and advisors
- RAG implementations
- Web search integration

Each practice module includes:
- LaTeX presentation files
- `/code/` directory with Spring application examples
- `/img/` directory with lesson-specific images
- Application configuration files (application.yml, docker-compose.yml)