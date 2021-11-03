resource "azurerm_virtual_network" "vmtf_vnet_Team2" {
  name                = "${var.prefix}-network"
  address_space       = ["10.0.0.0/16"]
  location            = var.resource_group_location
  resource_group_name =  azurerm_resource_group.Resource-Group-Azure-tf-Team2.name
}
