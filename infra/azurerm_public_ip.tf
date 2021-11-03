resource "azurerm_public_ip" "vmtf_pip_Team2" {
  name                = "${var.prefix}-public-ip"
  location            = var.resource_group_location
  resource_group_name =  azurerm_resource_group.Resource-Group-Azure-tf-Team2.name
  allocation_method   = "Dynamic"
  domain_name_label   = var.hostname
}
